package com.techpixe.picnie.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techpixe.picnie.template.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

}
