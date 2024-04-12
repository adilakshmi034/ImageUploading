package com.techpixe.picnie.template.service;

import org.springframework.web.multipart.MultipartFile;

import com.techpixe.picnie.template.entity.Image;

public interface ImageService {

	String uploadImage(MultipartFile file, String name);

	Image getImageById(Long id);

}
