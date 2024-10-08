package org.example.repository;

import org.example.model.modelDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo extends JpaRepository<modelDTO, Long> {
}
