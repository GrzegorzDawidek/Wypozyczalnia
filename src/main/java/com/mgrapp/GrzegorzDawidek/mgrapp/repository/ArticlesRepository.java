package com.mgrapp.GrzegorzDawidek.mgrapp.repository;

import com.mgrapp.GrzegorzDawidek.mgrapp.model.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Long> {

}
