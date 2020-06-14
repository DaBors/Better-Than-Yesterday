package com.base.betterthanyesterday;

import com.base.betterthanyesterday.Bean.Profile;
import com.base.betterthanyesterday.BeanManager.ProfileManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/bty")
public class BtyController {

    @Autowired
    private ProfileManager profileManager;

    @RequestMapping(path = "/index")
    public String index() {
      return "index";
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String email, @RequestParam String name, @RequestParam String password) {
      profileManager.createNewProfile(email, name, password);
      return "";
    }

    @PostMapping(path="/login")
    public @ResponseBody String login (@RequestParam String email, @RequestParam String password) {
      return "" + profileManager.authenticateProfile(email, password);
    }
  
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Profile> getAllProfiles() {
      return profileManager.getAllProfiles();
    }
    
}