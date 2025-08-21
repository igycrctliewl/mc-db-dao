package com.mikebro.jpatutorial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mikebro.jpatutorial.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee,Integer> {

}