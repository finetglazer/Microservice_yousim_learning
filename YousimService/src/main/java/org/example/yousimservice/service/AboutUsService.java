package org.example.yousimservice.service;

import org.example.yousimservice.dto.request.BaseRequestData;
import org.example.yousimservice.dto.response.aboutUs.ListAboutUsLanguageResponse;
import org.example.yousimservice.utils.Application.ApplicationException;

public interface AboutUsService {
    ListAboutUsLanguageResponse listAboutUs(BaseRequestData baseRequestData) throws ApplicationException;
}
