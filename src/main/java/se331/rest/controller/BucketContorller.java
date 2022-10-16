package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import se331.rest.util.CloudStorageHelper;

import java.io.IOException;
import java.rmi.ServerException;

@Controller
public class BucketContorller {
    @Autowired
    CloudStorageHelper cloudStorageHelper;
    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestPart(value = "file")MultipartFile file) throws IOException, ServerException{
        return ResponseEntity.ok(this.cloudStorageHelper.getImageUrl(file, "ImageUpload"));
    }
}
