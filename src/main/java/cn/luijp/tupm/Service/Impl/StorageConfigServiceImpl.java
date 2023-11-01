package cn.luijp.tupm.Service.Impl;

import cn.luijp.tupm.Exception.StorageConfigException;
import cn.luijp.tupm.Pojo.Mapper.StorageConfigMapper;
import cn.luijp.tupm.Pojo.SiteConfig;
import cn.luijp.tupm.Pojo.StorageConfig;
import cn.luijp.tupm.Service.StorageConfigService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageConfigServiceImpl implements StorageConfigService {

    @Autowired
    StorageConfigMapper storageConfigMapper;

    @Override
    public StorageConfig GetStorageConfigById(int TargetId) throws StorageConfigException{
        QueryWrapper<StorageConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",TargetId);
        StorageConfig storageConfig = storageConfigMapper.selectOne(queryWrapper);
        if(storageConfig == null) {
            throw new StorageConfigException("GET STORAGE CONFIG BY ID FAILED");
        }
        return storageConfig;
    }

    @Override
    public StorageConfig SetStorageConfig(StorageConfig storageConfig) throws StorageConfigException{
        QueryWrapper<StorageConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",storageConfig.getId());
        StorageConfig storageConfigRegion = storageConfigMapper.selectOne(queryWrapper);
        if(storageConfigRegion != null){
            DeleteStorageConfig(storageConfig.getId());
        }
        return NewStorageConfig(storageConfig);

    }

    @Override
    public Boolean DeleteStorageConfig(int TargetId) throws StorageConfigException {
        int count = storageConfigMapper.deleteById(TargetId);
        if(count > 0){
            return true;
        }
        throw new StorageConfigException("DELETE STORAGE CONFIG FAILED");
    }

    @Override
    public List<StorageConfig> ListAllConfig() {
        QueryWrapper<StorageConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("id",0);
        return storageConfigMapper.selectList(queryWrapper);
    }

    private StorageConfig NewStorageConfig(StorageConfig storageConfig) throws StorageConfigException{
        int count = storageConfigMapper.insert(storageConfig);
        if(count > 0){
            return storageConfig;
        }
        throw new StorageConfigException("INSERT NEW STORAGE CONFIG FAILED");
    }
}
