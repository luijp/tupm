package cn.luijp.tupm.Controller;

import cn.luijp.tupm.Exception.FileUploadException;
import cn.luijp.tupm.Exception.FileViewException;
import cn.luijp.tupm.Service.ImgService;
import cn.luijp.tupm.Utils.Repos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/img")
public class Img {

    private ImgService imgService;

    @Autowired
    public Img(ImgService imgService){
        this.imgService = imgService;
    }

    @GetMapping("/view")
    public ResponseEntity<Resource> ViewImg(@RequestParam("imgid") Integer ImgId) throws IOException, FileViewException {
        return imgService.ImgViewer(ImgId);
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> DownloadImg(@RequestParam("imgid") Integer ImgId) throws IOException, FileViewException {
        return imgService.Downloader(ImgId);
    }
}
