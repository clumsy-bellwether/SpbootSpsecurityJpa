package com.example.demo.domain.Respository;

import com.example.demo.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YF-yangwen on 2018/5/28.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
