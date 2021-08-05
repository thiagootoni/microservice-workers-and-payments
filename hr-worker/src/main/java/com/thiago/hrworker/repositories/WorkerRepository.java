package com.thiago.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.hrworker.models.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
