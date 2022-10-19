package com.iu.home.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileManager {

	public String saveFile(MultipartFile multipartFile, String path) throws Exception {
		String fileName = UUID.randomUUID().toString();
		StringBuffer sb = new StringBuffer();
		sb.append(fileName);
		sb.append("_");
		sb.append(multipartFile.getOriginalFilename());
		log.info("sb : {}", sb.toString());
		
		File file = new File(path, sb.toString());
//		FileCopyUtils.copy(multipartFile.getBytes(),file);
		multipartFile.transferTo(file);
		return sb.toString();
	}
}
