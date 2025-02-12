package com.ameda.works.user_service.service.bunnynet;

import org.springframework.web.multipart.MultipartFile;

public interface BunnyNetService {

    String uploadProfilePicture(MultipartFile file, String fileName, String requestKey) throws Exception;
}


