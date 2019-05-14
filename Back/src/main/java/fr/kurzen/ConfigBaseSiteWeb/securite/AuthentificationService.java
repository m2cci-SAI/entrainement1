package fr.kurzen.ConfigBaseSiteWeb.securite;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import fr.kurzen.ConfigBaseSiteWeb.enums.EnumRoles;
import fr.kurzen.ConfigBaseSiteWeb.model.User;
import fr.kurzen.ConfigBaseSiteWeb.service.UserService;

@Service
@Transactional
public class AuthentificationService implements UserDetailsService{

	@Autowired
	private UserService myuserservice;
	
	@Override
	public UserDetails loadUserByUsername(final String pseudo) {
		User user = myuserservice.findByPseudo(pseudo);
		List<GrantedAuthority> rules = this.getUserCredentials(user);
		return new org.springframework.security.core.userdetails.User(user.getPseudo(), user.getPassword(), rules);
		
	}

	private List<GrantedAuthority> getUserCredentials(User user) {
		 List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		 
		 authorities.add(new SimpleGrantedAuthority(EnumRoles.ROLE_USER.getRole()));
		 if(user.getRole().equals(EnumRoles.ROLE_ADMIN.getRole()))
		 {
			 authorities.add(new SimpleGrantedAuthority(EnumRoles.ROLE_ADMIN.getRole()));
		 }
		 
		return authorities;
	}

}