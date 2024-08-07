package org.example.yousimservice.dto.request.aboutUs;

import lombok.Data;
import org.example.yousimservice.dto.request.iRequestData;
import org.example.yousimservice.model.ViewAboutUsLanguage;

@Data
public class AboutUsAndLanguageRequest extends ViewAboutUsLanguage implements iRequestData {

    private int page;
    private int pageSize;
    @Override
    public boolean isValid() {
        return false;
    }
}