package com.lekodevs.wonderbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lekodevs.wonderbank.entity.Role;


@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{
	Role findByName(String name);

}
