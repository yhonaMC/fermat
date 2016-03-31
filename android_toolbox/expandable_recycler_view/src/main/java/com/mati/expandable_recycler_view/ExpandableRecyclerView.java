package com.mati.expandable_recycler_view;

<<<<<<< HEAD
=======
import android.content.Context;
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
import android.support.v7.widget.RecyclerView;

import com.bitdubai.fermat_android_api.layer.definition.wallet.interfaces.FermatSession;
import com.bitdubai.fermat_android_api.ui.enums.FermatRefreshTypes;
import com.bitdubai.fermat_android_api.ui.expandableRecicler.ExpandableRecyclerAdapter;
import com.bitdubai.fermat_android_api.ui.expandableRecicler.ParentListItem;
import com.bitdubai.fermat_android_api.ui.fragments.FermatWalletExpandableListFragment;
import com.bitdubai.fermat_api.layer.pip_engine.interfaces.ResourceProviderManager;
<<<<<<< HEAD
=======
import com.mati.expandable_recycler_view.holder.ChildViewHolder;
import com.mati.expandable_recycler_view.holder.GrouperParentViewHolder;
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

import java.util.List;

/**
 * Created by mati on 2016.02.23..
 */
public class ExpandableRecyclerView<M extends ParentListItem,S extends FermatSession,RE extends ResourceProviderManager> extends FermatWalletExpandableListFragment<M,S,RE> {


<<<<<<< HEAD
=======
    private ExpandableAdapter expandableAdapter;
    private boolean hasMenu;


>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

    private void ExpandableRecyclerView(){}


    @Override
    protected boolean hasMenu() {
        return false;
    }

    @Override
    protected int getLayoutResource() {
<<<<<<< HEAD
        return 0;//R.layout.base_main;
=======
        return R.layout.base_main;
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
    }

    @Override
    protected int getSwipeRefreshLayoutId() {
<<<<<<< HEAD
        return 0;
=======
        return R.id.swipe_refresh;
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
    }

    @Override
    protected int getRecyclerLayoutId() {
<<<<<<< HEAD
        return 0;
=======
        return R.id.open_contracts_recycler_view;
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
    }

    @Override
    protected boolean recyclerHasFixedSize() {
        return false;
    }

    @Override
    public List<M> getMoreDataAsync(FermatRefreshTypes refreshType, int pos) {
        return null;
    }

    @Override
    public void onPostExecute(Object... result) {

    }

    @Override
    public void onErrorOccurred(Exception ex) {

    }

    @Override
    public ExpandableRecyclerAdapter getAdapter() {
<<<<<<< HEAD
        return null;
=======
        return expandableAdapter;
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return null;
    }

<<<<<<< HEAD
    public static class Builder{

        private boolean hasMenu = false;

=======
    public void setAdapter(ExpandableAdapter adapter) {
        this.expandableAdapter = adapter;
    }

    public static class Builder<GROUPER_ITEM extends ParentListItem>{

        private Context context;
        private boolean hasMenu = false;
        private GrouperParentViewHolder parentHolder;
        private ChildViewHolder childHolder;
        private List<GROUPER_ITEM> grouperItemList;


        public Builder setHasMenu(boolean hasMenu) {
            this.hasMenu = hasMenu;
            return this;
        }

        public Builder setChildHolder(ChildViewHolder childHolder) {
            this.childHolder = childHolder;
            return this;
        }

        public Builder setParentHolder(GrouperParentViewHolder parentHolder) {
            this.parentHolder = parentHolder;
            return this;
        }

        public ExpandableRecyclerView build() {
            ExpandableRecyclerView expandableRecyclerView = new ExpandableRecyclerView();
            ExpandableAdapter expandableAdapter = new ExpandableAdapter(context, grouperItemList, context.getResources(), parentHolder, childHolder);
            expandableRecyclerView.setAdapter(expandableAdapter);
            return expandableRecyclerView;
        }
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

    }

}
