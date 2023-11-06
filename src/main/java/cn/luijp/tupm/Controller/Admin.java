package cn.luijp.tupm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Admin {

    @GetMapping("/dashboard")
    public String DashBoard(Model model){
        model.addAttribute("Title", "仪表盘");
        model.addAttribute("NavActive","Index");
        return "admin/dashboard";

    }

    @GetMapping("/siteconfig")
    public String SiteConfig(Model model) {
        model.addAttribute("Title", "站点设置");
        model.addAttribute("NavActive","SiteConfig");
        return "admin/siteConfig";
    }

    @GetMapping("/uploadconfig")
    public String UploadConfig(Model model) {
        model.addAttribute("Title", "上传设置");
        model.addAttribute("NavActive","UploadConfig");
        return "admin/uploadConfig";
    }


}
