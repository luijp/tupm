package cn.luijp.tupm.Service;

import cn.luijp.tupm.Exception.ConfigException;
import cn.luijp.tupm.Pojo.SiteConfig;
import cn.luijp.tupm.Utils.Repos;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;

public interface ConfigService {
    public List<SiteConfig> SaveConfig(List<SiteConfig> SiteConfigList) throws ConfigException;

    public List<SiteConfig> DeleteConfig(String ConfigName) throws ConfigException;
}
