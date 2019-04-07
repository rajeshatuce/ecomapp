package com.rt.service;

import static com.rt.constant.EComAppConstant.CDN_IMAGES_LOCATION;
import static com.rt.constant.EComAppConstant.CDN_WEBROOTPATH;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * File Manager Service to help in upload of static resource like images to CDN location
 */
@Service
public class EComAppFileManagerService {

  private final String cdnWebRootPath;

  public EComAppFileManagerService(@Value(CDN_WEBROOTPATH) String cdnWebRootPath) {
    this.cdnWebRootPath = cdnWebRootPath;
  }

  /**
   * Service to save uploaded file at CDN location folder for images and then return uploaded file
   * name
   *
   * @param imageFile uploaded
   * @return new uploaded file name
   */
  public String saveImagesToCDNLocation(MultipartFile imageFile) throws Exception {
    String cdnImageLocation = cdnWebRootPath + File.separator + CDN_IMAGES_LOCATION;
    File cdnImageFileDirectory = new File(cdnImageLocation);//1. Get CDN Image location
    String uploadedFileNameWithoutExtension = FilenameUtils
        .removeExtension(imageFile.getOriginalFilename()).replaceAll("\\s+", "");
    String uploadedFileNameExtension =
        "." + FilenameUtils.getExtension(imageFile.getOriginalFilename());
    File persistedFileName = File
        .createTempFile(uploadedFileNameWithoutExtension, uploadedFileNameExtension,
            cdnImageFileDirectory);//2. Prepare new name from uploaded filename
    byte[] bytes = imageFile.getBytes();
    Path path = Paths.get(persistedFileName.getAbsolutePath());
    Files.write(path, bytes);//3. Write binary to new file at CDN location
    return persistedFileName.getName();//4. Return new file name
  }

}
