package cn.luijp.tupm.Service.Impl;

import cn.luijp.tupm.Exception.FileIsEmptyException;
import cn.luijp.tupm.Service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("Local")
public class FileUploadServiceLocalImpl implements FileUploadService {
    @Override
    public void FileUpload(MultipartFile UploadFile) throws FileIsEmptyException{
        if(UploadFile.isEmpty()){
            throw new FileIsEmptyException();
        }

    }
}
