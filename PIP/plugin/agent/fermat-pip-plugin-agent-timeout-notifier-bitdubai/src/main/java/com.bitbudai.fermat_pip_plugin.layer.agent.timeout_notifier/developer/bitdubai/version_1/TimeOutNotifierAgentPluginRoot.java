package com.bitbudai.fermat_pip_plugin.layer.agent.timeout_notifier.developer.bitdubai.version_1;

import com.bitbudai.fermat_pip_plugin.layer.agent.timeout_notifier.developer.bitdubai.version_1.database.TimeOutNotifierAgentDatabaseDao;
import com.bitbudai.fermat_pip_plugin.layer.agent.timeout_notifier.developer.bitdubai.version_1.database.TimeOutNotifierAgentDeveloperDatabaseFactory;
import com.bitbudai.fermat_pip_plugin.layer.agent.timeout_notifier.developer.bitdubai.version_1.events.TimeOutMonitoringAgent;
import com.bitbudai.fermat_pip_plugin.layer.agent.timeout_notifier.developer.bitdubai.version_1.exceptions.CantInitializeTimeOutNotifierAgentDatabaseException;
import com.bitbudai.fermat_pip_plugin.layer.agent.timeout_notifier.developer.bitdubai.version_1.structure.TimeOutNotifierAgent;
import com.bitbudai.fermat_pip_plugin.layer.agent.timeout_notifier.developer.bitdubai.version_1.structure.TimeOutNotifierAgentPool;
import com.bitbudai.fermat_pip_plugin.layer.agent.timeout_notifier.developer.bitdubai.version_1.structure.TimeOutNotifierManager;
import com.bitbudai.fermat_pip_plugin.layer.agent.timeout_notifier.developer.bitdubai.version_1.utils.FermatActorImpl;
import com.bitdubai.fermat_api.CantStartAgentException;
import com.bitdubai.fermat_api.CantStartPluginException;
import com.bitdubai.fermat_api.layer.actor.FermatActor;
import com.bitdubai.fermat_api.layer.all_definition.common.system.abstract_classes.AbstractPlugin;
import com.bitdubai.fermat_api.layer.all_definition.common.system.annotations.NeededAddonReference;
import com.bitdubai.fermat_api.layer.all_definition.common.system.utils.PluginVersionReference;
import com.bitdubai.fermat_api.layer.all_definition.developer.DatabaseManagerForDevelopers;
import com.bitdubai.fermat_api.layer.all_definition.developer.DeveloperDatabase;
import com.bitdubai.fermat_api.layer.all_definition.developer.DeveloperDatabaseTable;
import com.bitdubai.fermat_api.layer.all_definition.developer.DeveloperDatabaseTableRecord;
import com.bitdubai.fermat_api.layer.all_definition.developer.DeveloperObjectFactory;
import com.bitdubai.fermat_api.layer.all_definition.enums.Actors;
import com.bitdubai.fermat_api.layer.all_definition.enums.Addons;
import com.bitdubai.fermat_api.layer.all_definition.enums.Layers;
import com.bitdubai.fermat_api.layer.all_definition.enums.Platforms;
import com.bitdubai.fermat_api.layer.all_definition.enums.Plugins;
import com.bitdubai.fermat_api.layer.all_definition.util.Version;
import com.bitdubai.fermat_api.layer.osa_android.database_system.PluginDatabaseSystem;
import com.bitdubai.fermat_pip_api.layer.platform_service.error_manager.enums.UnexpectedPluginExceptionSeverity;
import com.bitdubai.fermat_pip_api.layer.platform_service.error_manager.interfaces.ErrorManager;
import com.bitdubai.fermat_pip_api.layer.platform_service.event_manager.interfaces.EventManager;

import java.util.List;
import java.util.UUID;


/**
 * Created by rodrigo on 3/27/16.
 */
public class TimeOutNotifierAgentPluginRoot extends AbstractPlugin implements DatabaseManagerForDevelopers {

    @NeededAddonReference(platform = Platforms.PLUG_INS_PLATFORM   , layer = Layers.PLATFORM_SERVICE, addon = Addons.ERROR_MANAGER         )
    private ErrorManager errorManager;

    @NeededAddonReference(platform = Platforms.PLUG_INS_PLATFORM   , layer = Layers.PLATFORM_SERVICE, addon = Addons.EVENT_MANAGER         )
    private EventManager eventManager;

    @NeededAddonReference(platform = Platforms.OPERATIVE_SYSTEM_API, layer = Layers.SYSTEM, addon = Addons.PLUGIN_DATABASE_SYSTEM)
    private PluginDatabaseSystem pluginDatabaseSystem;


    /**
     * Class Variables
     */
    TimeOutNotifierAgentDeveloperDatabaseFactory timeOutNotifierAgentDeveloperDatabaseFactory;
    TimeOutNotifierAgentPool timeOutNotifierAgentPool;
    TimeOutNotifierManager timeOutNotifierManager;
    TimeOutNotifierAgentDatabaseDao dao;
    TimeOutMonitoringAgent monitoringAgent;

    /**
     * constructor
     */
    public TimeOutNotifierAgentPluginRoot() {
        super(new PluginVersionReference(new Version()));
    }


    private void initializeDatabase(){
        timeOutNotifierAgentDeveloperDatabaseFactory = new TimeOutNotifierAgentDeveloperDatabaseFactory(this.pluginDatabaseSystem, this.pluginId);
        try {
            timeOutNotifierAgentDeveloperDatabaseFactory.initializeDatabase();
        } catch (CantInitializeTimeOutNotifierAgentDatabaseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DeveloperDatabase> getDatabaseList(DeveloperObjectFactory developerObjectFactory) {
        if (timeOutNotifierAgentDeveloperDatabaseFactory == null)
            initializeDatabase();

        return timeOutNotifierAgentDeveloperDatabaseFactory.getDatabaseList(developerObjectFactory);
    }

    @Override
    public List<DeveloperDatabaseTable> getDatabaseTableList(DeveloperObjectFactory developerObjectFactory, DeveloperDatabase developerDatabase) {
        if (timeOutNotifierAgentDeveloperDatabaseFactory == null)
            initializeDatabase();

        return timeOutNotifierAgentDeveloperDatabaseFactory.getDatabaseTableList(developerObjectFactory);
    }

    @Override
    public List<DeveloperDatabaseTableRecord> getDatabaseTableContent(DeveloperObjectFactory developerObjectFactory, DeveloperDatabase developerDatabase, DeveloperDatabaseTable developerDatabaseTable) {
        if (timeOutNotifierAgentDeveloperDatabaseFactory == null)
            initializeDatabase();

        return timeOutNotifierAgentDeveloperDatabaseFactory.getDatabaseTableContent(developerObjectFactory, developerDatabaseTable);
    }

    @Override
    public void start() throws CantStartPluginException {
        /**
         * Instantiate agents.
         */
        timeOutNotifierAgentPool = new TimeOutNotifierAgentPool(getDao(), this.errorManager);
        timeOutNotifierManager = new TimeOutNotifierManager(getDao(), this.errorManager, this.timeOutNotifierAgentPool);

        //starts the agent
        monitoringAgent = new TimeOutMonitoringAgent(getDao(), timeOutNotifierAgentPool, errorManager, eventManager);
        try {
            monitoringAgent.start();
        } catch (CantStartAgentException e) {
            CantStartPluginException exception = new CantStartPluginException(e, "Unable to start Timeout Monitoring agent", "unknown");
            errorManager.reportUnexpectedPluginException(Plugins.TIMEOUT_NOTIFIER, UnexpectedPluginExceptionSeverity.DISABLES_THIS_PLUGIN, exception);
            throw exception;
        }

        testAddNewAgent();
    }


    @Override
    public void stop() {

    }

    private void testAddNewAgent(){
        try{
            FermatActorImpl owner = new FermatActorImpl();
            owner.setPublicKey(UUID.randomUUID().toString());
            owner.setType(Actors.CBP_CRYPTO_CUSTOMER);
            owner.setName("Test Rodrigo");
            timeOutNotifierManager.addNew(40000, "Prueba Rodrigo 1", owner);

            System.out.println("***TimeOutNotifier*** " + timeOutNotifierManager.getTimeOutAgents(owner).toString());
            System.out.println("***TimeOutNotifier*** " + timeOutNotifierManager.getTimeOutAgents().size());
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    private TimeOutNotifierAgentDatabaseDao getDao(){
        if (dao == null)
            dao = new TimeOutNotifierAgentDatabaseDao(this.pluginDatabaseSystem, this.pluginId);

        return dao;
    }
}
