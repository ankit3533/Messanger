package org.koushik.javabrains.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.messanger.database.DatabaseClass;
import org.koushik.javabrains.messanger.model.Profile;

public class ProfileService {
	
	Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("Ankit", new Profile(1L,"Ankit","Ankit","Mittal"));
		profiles.put("Ankit2", new Profile(2L,"Ankit2","Ankit2","Mittal2"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());

	}

	public Profile getProfile(String name) {
		return profiles.get(name);

	}
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	public void deleteProfile(String name) {
		profiles.remove(name);

	}
	public Profile updateProfile(Profile Profile) {
		if(Profile.getProfileName()!= null)
			return null;
		profiles.put(Profile.getProfileName(),Profile);
		return Profile;

	}
	
}
