package org.example.yousimservice.repository;

import org.example.yousimservice.model.ViewAboutUsLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AboutUsAndLanguageRepository extends JpaRepository<ViewAboutUsLanguage, Integer> {
    @Query(value = "select c from ViewAboutUsLanguage c where  (c.type in :type) and (c.language in :lang)")
    List<ViewAboutUsLanguage> aboutUsList(int type, String lang);
}
