package cn.luijp.tupm.Service;

import cn.luijp.tupm.Pojo.SiteConfig;

import java.util.List;

public interface SiteConfigService {
    public String GetConfig(String name);

    public Boolean SetConfig(String name, String value);

    public Boolean DelConfig(String name);

    public List<SiteConfig> ListAllConfig();

}
