package org.yeolmae.challenge.domain.dto.upload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class UploadFileReply {

    private List<MultipartFile> files;
}
