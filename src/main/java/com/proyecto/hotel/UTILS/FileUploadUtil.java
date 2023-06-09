package com.proyecto.hotel.UTILS;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
    
    public static void saveFile(String uploadDir, String file, MultipartFile multipartFile) throws IOException{
        Path uploadPath = Paths.get(uploadDir);

        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        try (InputStream input = multipartFile.getInputStream()){
            Path filePath = uploadPath.resolve(file);
            Files.copy(input, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("No pudo guardarse el archivo " + file , e);
        }
    }
    
}
