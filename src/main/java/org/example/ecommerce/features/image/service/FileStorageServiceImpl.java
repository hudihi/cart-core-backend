package org.example.ecommerce.features.image.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServiceImpl implements FileStorageService{
    @Override
    public String uploadFile(MultipartFile file) {
        /**
         * Logic to upload file to AWS S3 / Cloudinary and return the public URL
         * e.g., return "https://my-cdn.com/products/image-uuid.jpg
         * */
        return "";
    }

    @Override
    public void deleteFile(String fileUrl) {
        /**
         * Logic to remove file from S3 bucket
         * */
    }
}
