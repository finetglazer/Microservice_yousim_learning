package org.example.yousimservice.dto.response.aboutUs;

import lombok.Data;
import org.example.yousimservice.dto.request.aboutUs.AboutUsAndLanguageRequest;
import org.example.yousimservice.dto.response.BaseResponseData;
import java.util.List;

@Data
public class ListAboutUsLanguageResponse {
    private int totalPage;
    private int totalItem;
    private List<AboutUsAndLanguageResponse> aboutUsAndLanguageResponseList;
}
