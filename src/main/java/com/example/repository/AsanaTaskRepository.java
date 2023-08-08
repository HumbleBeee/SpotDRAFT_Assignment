package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.AsanaTask;

public interface AsanaTaskRepository extends JpaRepository<AsanaTask, Long> {

}
