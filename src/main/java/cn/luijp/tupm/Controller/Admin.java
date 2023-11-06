package cn.luijp.tupm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Admin {

    @GetMapping("/")
    public String AdminIndex(Model model){
        model.addAttribute("Title", "Admin Index");
        model.addAttribute("NavActive","Index");
        return "admin/index";

    }

    @GetMapping("/siteconfig")
    public String SiteConfig(Model model) {
        model.addAttribute("Title", "SiteConfig");
        model.addAttribute("NavActive","SiteConfig");
        return "admin/siteConfig";
    }

    @GetMapping("/uploadconfig")
    public String UploadConfig(Model model) {
        model.addAttribute("Title", "UploadConfig");
        model.addAttribute("NavActive","UploadConfig");
        return "admin/uploadConfig";
    }


}
