package com.etoak.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.etoak.bean.Car;
import com.etoak.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/car")
@Slf4j
public class CarController {
	
	@Autowired
	CarService carService;
	
	//跳转到car添加页面
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "car/add";
	}
	
	@RequestMapping("/add")
	public String add(MultipartFile file,Car car) throws IllegalStateException, IOException {
		
		String originalFilename = file.getOriginalFilename();
		log.info("文件名称 - {}",file.getOriginalFilename());
		log.info("param car - {}", car);
		
		String uuid = UUID.randomUUID().toString().replaceAll("-","");
		
		String newFilename = uuid + "_" + originalFilename;
		
		//目标文件d:/upload/uuid_老文件名.jpg
		File destFile = new File("d:/upload",newFilename);
		
		file.transferTo(destFile);
		
		car.setPic("/pic/" + newFilename);
		//调用服务层添加车辆信息
		carService.addCar(car);
		
		
		return "redirect:/car/toAdd";
	}
}
