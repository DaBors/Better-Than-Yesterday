package com.base.betterthanyesterday.BeanManager;

import com.base.betterthanyesterday.Bean.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    
}