package mc.minecraft.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mc.minecraft.db.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee,Integer> {

}