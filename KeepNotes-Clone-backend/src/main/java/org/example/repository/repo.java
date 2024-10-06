package org.example.repository;

import org.example.model.model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo extends JpaRepository<model, Long> {
}
