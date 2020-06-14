package com.base.betterthanyesterday.BeanManager;

import java.util.UUID;

import com.base.betterthanyesterday.Bean.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ProfileManager {
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfileRepository profileRepository;

    public void createNewProfile(String email, String name, String password) {
        Profile newProfile = new Profile(email, name, passwordEncoder.encode(password), UUID.randomUUID().toString());
        profileRepository.save(newProfile);
    }

    public boolean authenticateProfile(String email, String password) {
        for(Profile profile : profileRepository.findAll()){
            if(profile.getEmail().equals(email)){
                return passwordEncoder.matches(password, profile.getPasswordHash());
            }
        }
        return false;
    }

    public Iterable<Profile> getAllProfiles(){
        return profileRepository.findAll();
    }

}