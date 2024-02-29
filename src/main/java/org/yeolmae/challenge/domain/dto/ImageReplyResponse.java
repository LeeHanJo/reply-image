package org.yeolmae.challenge.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageReplyResponse {

    private String uuid;

    private String fileName;

    private int ord;
}
