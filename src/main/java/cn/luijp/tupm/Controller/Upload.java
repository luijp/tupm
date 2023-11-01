package cn.luijp.tupm.Controller;

import cn.luijp.tupm.Service.UploadService;
import cn.luijp.tupm.Utils.Repos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class Upload {

    @Autowired
    UploadService uploadService;

    @PostMapping("/imgupload")
    public Repos ImgUpload(@RequestParam("imgfile")MultipartFile imgfile,
                           @RequestParam("target") int TargetId) {

        Repos repos = new Repos();
        return repos;

    }
}
