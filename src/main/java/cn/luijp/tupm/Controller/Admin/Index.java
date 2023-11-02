package cn.luijp.tupm.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {

    @GetMapping("/admin")
    public String AdminIndex(Model model){
        model.addAttribute("title", "Admin Index");
        return "admin/index";

    }


}
