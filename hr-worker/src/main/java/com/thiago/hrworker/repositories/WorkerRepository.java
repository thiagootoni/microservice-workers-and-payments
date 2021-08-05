package com.thiago.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiago.hrworker.models.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
