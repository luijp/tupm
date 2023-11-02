package cn.luijp.tupm.Service.Impl;

import cn.luijp.tupm.Enum.ReposCodeEnum;
import cn.luijp.tupm.Exception.FileViewException;
import cn.luijp.tupm.Pojo.FileUpload;
import cn.luijp.tupm.Pojo.Mapper.FileUploadMapper;
import cn.luijp.tupm.Service.FileViewService;
import cn.luijp.tupm.Service.ImgService;
import cn.luijp.tupm.Utils.FileUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.annotation.Target;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;

@Service
public class ImgServiceImpl implements ImgService {

  FileViewService fileViewService;

  @Autowired
  public ImgServiceImpl(FileViewService fileViewService){
      this.fileViewService = fileViewService;
  }

  public ResponseEntity<Resource> Downloader(int TargetId) throws IOException, FileViewException {
      ViewFileClass viewFileClass = fileViewService.ViewFile(TargetId);
      Path ImagePath = Paths.get(viewFileClass.getResource().getURI());
      byte[] ImageData = Files.readAllBytes(ImagePath);
      ByteArrayResource byteArrayResource = new ByteArrayResource(ImageData);
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
      headers.setContentDispositionFormData("attachment", viewFileClass.getFileUpload().getOriginname());
      return ResponseEntity.ok().headers(headers).body(byteArrayResource);
  }

    @Override
    public ResponseEntity<Resource> ImgViewer(int TargetId) throws IOException, FileViewException {
        ViewFileClass viewFileClass = fileViewService.ViewFile(TargetId);
        Path ImagePath = Paths.get(viewFileClass.getResource().getURI());
        byte[] ImageData = Files.readAllBytes(ImagePath);
        ByteArrayResource byteArrayResource = new ByteArrayResource(ImageData);

        String FileExtension = FileUtils.GetFileExtendsion(viewFileClass.getFileUpload().getOriginname());
        MediaType mediaType = FileUtils.GetFileTypeByExtension(FileExtension);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        return ResponseEntity.ok().headers(headers).body(byteArrayResource);
    }


}
