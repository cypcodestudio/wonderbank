package com.lekodevs.wonderbank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lekodevs.wonderbank.entity.UserRole;



@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole, Long>{
	
	List<UserRole> findAllByUserId(Long id);

}
