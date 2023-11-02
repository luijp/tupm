package cn.luijp.tupm.Controller;

import cn.luijp.tupm.Pojo.SiteConfig;
import cn.luijp.tupm.Service.ConfigService;
import cn.luijp.tupm.Utils.Repos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/config")
public class Config {

    private ConfigService configService;

    @Autowired
    public Config(ConfigService configService){
        this.configService = configService;
    }

    @PostMapping("/save")
    public Repos<List<SiteConfig>> SaveConfig(@RequestParam("configname") String ConfigName,
                                    @RequestParam("ConfigValue") String ConfigValue) {
        SiteConfig siteConfig = new SiteConfig();
        siteConfig.setName(ConfigName);
        siteConfig.setValue(ConfigValue);
        List<SiteConfig> siteConfigList = new ArrayList<>();
        siteConfigList.add(siteConfig);
        List<SiteConfig> NewSiteConfigList = configService.SaveConfig(siteConfigList);
        return Repos.success(NewSiteConfigList);
    }

    @PostMapping("/saveall")
    public Repos<List<SiteConfig>> SaveAllConfig(@RequestParam("configlist") List<SiteConfig> SiteConfigList) {
        List<SiteConfig> NewSiteConfigList = configService.SaveConfig(SiteConfigList);
        return Repos.success(NewSiteConfigList);
    }
}
