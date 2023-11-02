package cn.luijp.tupm.Service.Impl;

import cn.luijp.tupm.Enum.ReposCodeEnum;
import cn.luijp.tupm.Exception.ConfigException;
import cn.luijp.tupm.Pojo.Mapper.SiteConfigMapper;
import cn.luijp.tupm.Pojo.SiteConfig;
import cn.luijp.tupm.Service.ConfigService;
import cn.luijp.tupm.Service.SiteConfigService;
import cn.luijp.tupm.Utils.Repos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ConfigServiceImpl implements ConfigService {

    SiteConfigService siteConfigService;

    @Autowired
    public ConfigServiceImpl(SiteConfigService siteConfigService) {
        this.siteConfigService = siteConfigService;
    }
    @Override
    public List<SiteConfig> SaveConfig(List<SiteConfig> NewSiteConfigList) throws ConfigException {
        List<SiteConfig> OriginSiteConfigList = siteConfigService.ListAllConfig();
        Hashtable<String,SiteConfig> OriginSiteConfigTable = new Hashtable<>();
        for(SiteConfig OriginSiteConfigDictItem : OriginSiteConfigList) {
            OriginSiteConfigTable.put(OriginSiteConfigDictItem.getName(),OriginSiteConfigDictItem);
        }
        for(SiteConfig NewSiteConfigItem : NewSiteConfigList) {
            boolean ifSave = true;
            if(OriginSiteConfigTable.containsKey(NewSiteConfigItem.getName())){
                if(!OriginSiteConfigTable.get(NewSiteConfigItem.getName()).equals(NewSiteConfigItem)){
                    ifSave = false;
                }
            }
            if(ifSave){
                //INSERT
                siteConfigService.SetConfig(NewSiteConfigItem.getName(),NewSiteConfigItem.getValue());
            }
        }
        return siteConfigService.ListAllConfig();
    }

    @Override
    public List<SiteConfig> DeleteConfig(String ConfigName) throws ConfigException{
        Boolean isSuccess = siteConfigService.DelConfig(ConfigName);
        if(!isSuccess){
            throw new ConfigException(ReposCodeEnum.SITE_CONFIG_DELETE_FAILED);
        }

        return siteConfigService.ListAllConfig();

    }
}
