package com.techpixe.picnie.template.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.techpixe.picnie.template.entity.Image;
import com.techpixe.picnie.template.service.ImageService;

@RestController
@RequestMapping("/images")
public class ImageController {
	@Autowired
    private ImageService imageService;
	
	@PostMapping("/upload")
	public List<String> uploadImages(@RequestParam("files") List<MultipartFile> files,
	                                 @RequestParam("names") String names) {
	    List<String> imageUrls = new ArrayList<>();
	    for (int i = 0; i < files.size(); i++) {
	        String imageUrl = imageService.uploadImage(files.get(i), names);
	        imageUrls.add(imageUrl);
	    }
	    return imageUrls;
	}
    public String uploadImage(MultipartFile file,String name) {
        return imageService.uploadImage(file, name);
    }

    @GetMapping("/{id}")
    public Image getImageById(@PathVariable Long id) {
        return imageService.getImageById(id);
    }

}
