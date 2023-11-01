package cn.luijp.tupm.Service;

import cn.luijp.tupm.Pojo.StorageConfig;

import java.util.List;

public interface StorageConfigService {
    public StorageConfig GetStorageConfigById(int TargetId);

    public StorageConfig SetStorageConfig(StorageConfig storageConfig);

    public Boolean DeleteStorageConfig(int TargetId);

    public List<StorageConfig> ListAllConfig();
}
