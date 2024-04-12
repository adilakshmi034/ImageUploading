package com.techpixe.picnie.template.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.techpixe.picnie.template.entity.Image;
import com.techpixe.picnie.template.repository.ImageRepository;
import com.techpixe.picnie.template.service.ImageService;

@Service
public class imageimpl implements ImageService{
	
	@Autowired
	ImageRepository imageRepository;

	public String uploadImage(MultipartFile file, String name) {
		  String imageUrl = "https://example.com/images/" + file.getOriginalFilename(); // Replace with your URL logic
	        Image image = new Image();
	        image.setName(name);
	        image.setImageUrl(imageUrl);
	        imageRepository.save(image);
	        return imageUrl;
	}

	public Image getImageById(Long id) {
		return imageRepository.findById(id).orElse(null);
	}

}
