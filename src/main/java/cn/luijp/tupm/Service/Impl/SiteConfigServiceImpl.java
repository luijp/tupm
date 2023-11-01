package cn.luijp.tupm.Service.Impl;

import cn.luijp.tupm.Exception.ConfigException;
import cn.luijp.tupm.Pojo.Mapper.SiteConfigMapper;
import cn.luijp.tupm.Pojo.SiteConfig;
import cn.luijp.tupm.Service.SiteConfigService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SiteConfigServiceImpl implements SiteConfigService {

    @Autowired
    SiteConfigMapper siteConfigMapper;

    @Override
    public SiteConfig GetConfig(String name) throws ConfigException {
        QueryWrapper<SiteConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        SiteConfig siteConfig = siteConfigMapper.selectOne(queryWrapper);
        if(siteConfig == null){
            throw new ConfigException("Site Config Not Found");
        }
        return siteConfig;
    }

    @Override
    public SiteConfig SetConfig(String name, String value) throws ConfigException {
        QueryWrapper<SiteConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        SiteConfig siteConfig = siteConfigMapper.selectOne(queryWrapper);

        if(!siteConfig.getValue().isEmpty()){
            DelConfig(name);
        }
        return NewConfig(name, value);

    }

    @Override
    public Boolean DelConfig(String name) throws ConfigException {
        QueryWrapper<SiteConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        SiteConfig siteConfig = siteConfigMapper.selectOne(queryWrapper);

        int count = siteConfigMapper.deleteById(siteConfig.getId());
        if(count > 0) {
            return true;
        }else {
            throw new ConfigException("DELETE FAILED");
        }

    }

    @Override
    public List<SiteConfig> ListAllConfig() {
        QueryWrapper<SiteConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("id",0);
        return siteConfigMapper.selectList(queryWrapper);
    }


    private SiteConfig NewConfig(String name, String value) throws ConfigException{
        SiteConfig siteConfig = new SiteConfig();
        siteConfig.setName(name);
        siteConfig.setValue(value);
        int count = siteConfigMapper.insert(siteConfig);
        if(count > 0){
            return siteConfig;
        }else{
            throw new ConfigException("CREATE CONFIG FAILED");
        }
    }
}
