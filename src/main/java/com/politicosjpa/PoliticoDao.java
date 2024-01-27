package com.politicosjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliticoDao extends JpaRepository<Politico, String> {




}
