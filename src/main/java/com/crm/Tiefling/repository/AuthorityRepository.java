package com.crm.Tiefling.repository;

import com.crm.Tiefling.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    @Query("select a from Authority a where a.authority like ?1")
    Authority loadAuthorityByName(String name);
}
