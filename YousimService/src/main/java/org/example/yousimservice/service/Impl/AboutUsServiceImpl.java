package org.example.yousimservice.service.Impl;

import java.util.ArrayList;
import java.util.List;
import org.example.yousimservice.dto.request.BaseRequestData;
import org.example.yousimservice.dto.request.aboutUs.AboutUsAndLanguageRequest;
import org.example.yousimservice.dto.response.aboutUs.AboutUsAndLanguageResponse;
import org.example.yousimservice.dto.response.aboutUs.ListAboutUsLanguageResponse;
import org.example.yousimservice.model.ViewAboutUsLanguage;
import org.example.yousimservice.repository.AboutUsAndLanguageRepository;
import org.example.yousimservice.service.AboutUsService;
import org.example.yousimservice.utils.Application.ApplicationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutUsServiceImpl implements AboutUsService {
    @Autowired
    private AboutUsAndLanguageRepository aboutUsAndLanguageRepository;

    @Override
    public ListAboutUsLanguageResponse listAboutUs(BaseRequestData baseRequestData) throws ApplicationException {
        AboutUsAndLanguageRequest aboutUsAndLanguageRequest = (AboutUsAndLanguageRequest) baseRequestData.getWsRequest();
        List<ViewAboutUsLanguage> aboutUsLanguageList = aboutUsAndLanguageRepository.aboutUsList(aboutUsAndLanguageRequest.getType(), aboutUsAndLanguageRequest.getLanguage());
        List<AboutUsAndLanguageResponse> aboutUsAndLanguageResponseList = new ArrayList<>();
//        for (ViewAboutUsLanguage view: aboutUsLanguageList) {
//            AboutUsAndLanguageResponse aboutUsAndLanguageResponse = new AboutUsAndLanguageResponse();
//            BeanUtils.copyProperties(view, aboutUsAndLanguageResponse);
//            aboutUsAndLanguageResponseList.add(aboutUsAndLanguageResponse);
//        }
        // stream type
        aboutUsLanguageList.forEach(view -> {
            AboutUsAndLanguageResponse aboutUsAndLanguageResponse = new AboutUsAndLanguageResponse();
            BeanUtils.copyProperties(view, aboutUsAndLanguageResponse);
            aboutUsAndLanguageResponseList.add(aboutUsAndLanguageResponse);
        });
        ListAboutUsLanguageResponse listAboutUsLanguageResponse = new ListAboutUsLanguageResponse();
        listAboutUsLanguageResponse.setAboutUsAndLanguageResponseList(aboutUsAndLanguageResponseList);
        return listAboutUsLanguageResponse;
    }
}
