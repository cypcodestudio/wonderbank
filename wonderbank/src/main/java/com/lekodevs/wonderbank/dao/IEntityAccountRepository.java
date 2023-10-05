package com.lekodevs.wonderbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.lekodevs.wonderbank.entity.EntityAccount;
import com.lekodevs.wonderbank.entity.WEntity;

@Repository
public interface IEntityAccountRepository extends JpaRepository<EntityAccount, Long>{
	List<EntityAccount> findAllByAccountHolder(WEntity entity);
}
