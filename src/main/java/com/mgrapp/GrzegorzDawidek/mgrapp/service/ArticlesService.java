package com.mgrapp.GrzegorzDawidek.mgrapp.service;

import com.mgrapp.GrzegorzDawidek.mgrapp.model.Articles;
import com.mgrapp.GrzegorzDawidek.mgrapp.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArticlesService {

    @Autowired
    ArticlesRepository articlesRepository;

    public List<Articles> listAll() {
        return articlesRepository.findAll();
    }

    public void save(Articles articles) {
        articlesRepository.save(articles);
    }


}
