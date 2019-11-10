package com.syriatel.bpm.springtest.repo;

import com.syriatel.bpm.springtest.entity.Role;
import com.syriatel.bpm.springtest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Users extends JpaRepository<User,Long> {

}
