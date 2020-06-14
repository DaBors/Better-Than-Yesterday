package com.base.betterthanyesterday.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Profile {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String email;

    private String name;

    private String passwordHash;

    public Profile() {}

    public Profile(String email, String name, String passwordHash, String id) {
        this.email = email;
        this.name = name;
        this.passwordHash = passwordHash;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    
    @Override
	public String toString() {
		return "Profile{" +
			"id=" + id +
			", email='" + email + '\'' +
			", name='" + name + '\'' +
			", passwordHash='" + passwordHash + '\'' +
			'}';
	}

}