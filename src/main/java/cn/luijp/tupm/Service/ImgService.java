package cn.luijp.tupm.Service;

import cn.luijp.tupm.Exception.FileViewException;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.MalformedURLException;

public interface ImgService {
    public ResponseEntity<Resource> ImgViewer(int TargetId) throws IOException, FileViewException;

    public ResponseEntity<Resource> Downloader(int TargetId) throws IOException, FileViewException;
}
