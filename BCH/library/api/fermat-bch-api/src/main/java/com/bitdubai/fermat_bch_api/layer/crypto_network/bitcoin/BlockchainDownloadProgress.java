package com.bitdubai.fermat_bch_api.layer.crypto_network.bitcoin;

import com.bitdubai.fermat_api.layer.all_definition.enums.BlockchainNetworkType;

/**
 * Created by rodrigo on 3/9/16.
 */
public class BlockchainDownloadProgress {
    BlockchainNetworkType blockchainNetworkType;
    int pendingBlocks;
    int totalBlocks;
    int downloadedBlocks;
<<<<<<< HEAD
    long progress;

    public BlockchainDownloadProgress(BlockchainNetworkType blockchainNetworkType, int pendingBlocks, int totalBlocks, int downloadedBlocks, long progress) {
=======
    int progress;
    String downloader;

    public BlockchainDownloadProgress(BlockchainNetworkType blockchainNetworkType, int pendingBlocks, int totalBlocks, int downloadedBlocks, int progress) {
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
        this.blockchainNetworkType = blockchainNetworkType;
        this.pendingBlocks = pendingBlocks;
        this.totalBlocks = totalBlocks;
        this.downloadedBlocks = downloadedBlocks;
        this.progress = progress;
    }

<<<<<<< HEAD
=======
    /**
     * Getters and Setters
     */

>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
    public BlockchainNetworkType getBlockchainNetworkType() {
        return blockchainNetworkType;
    }

    public int getPendingBlocks() {
        return pendingBlocks;
    }

    public int getTotalBlocks() {
        return totalBlocks;
    }

    public int getDownloadedBlocks() {
        return downloadedBlocks;
    }

<<<<<<< HEAD
    public long getProgress() {
        return progress;
    }
=======
    public int getProgress() {
        return progress;
    }

    public void setPendingBlocks(int pendingBlocks) {
        this.pendingBlocks = pendingBlocks;

        downloadedBlocks = totalBlocks - pendingBlocks;
        progress = (totalBlocks > 0) ? ((pendingBlocks * 100) / totalBlocks) : 100;

    }

    public void setTotalBlocks(int totalBlocks) {
        this.totalBlocks = totalBlocks;
    }

    public String getDownloader() {
        return downloader;
    }

    public void setDownloader(String downloader) {
        this.downloader = downloader;
    }
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
}
