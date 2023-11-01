package cn.luijp.tupm.Controller;

import cn.luijp.tupm.Pojo.FileUpload;
import cn.luijp.tupm.Pojo.StorageConfig;
import cn.luijp.tupm.Service.StorageConfigService;
import cn.luijp.tupm.Service.UploadService;
import cn.luijp.tupm.Utils.Repos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/upload")
public class Upload {


    UploadService uploadService;
    StorageConfigService storageConfigService;

    @Autowired
    public Upload(UploadService uploadService,
                  StorageConfigService storageConfigService){
        this.uploadService = uploadService;
        this.storageConfigService = storageConfigService;
    }

    @PostMapping("/imgupload")
    public Repos<Object> ImgUpload(@RequestParam("filename") MultipartFile FileName,
                           @RequestParam("targetid") int TargetId) {

        uploadService.ImgUpload(FileName, TargetId);
        return Repos.success();

    }

    @GetMapping("/get_target_id")
    public Repos<List<StorageConfig>> GetTargetId(){
        return Repos.success(storageConfigService.ListAllConfig());
    }
}
