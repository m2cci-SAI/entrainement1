package fr.kurzen.ConfigBaseSiteWeb.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.kurzen.ConfigBaseSiteWeb.model.User;
import fr.kurzen.ConfigBaseSiteWeb.repository.UserRepository;

@Service
public class UserService implements UserDetailsService
{
	@Autowired
	UserRepository userRepository;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public User findByPseudo(String pseudo)
	{
		Optional<User> u = userRepository.findByPseudo(pseudo);
		if(u.isPresent())
		{
			return u.get();
		}
		else
		{
			return null;
		}
	}
	
	public User insertMyUser(User user)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return userRepository.save(user);
	}
	
	public User updateMyUser(User user)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	public List<User> updateMyUser(List<User> users)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		for(User u : users)
		{
			u.setPassword(passwordEncoder.encode(u.getPassword()));
		}
		
		return (List<User>) userRepository.saveAll(users);
	}
	
	public User verifPassword(User args)
	{
		User user = findByPseudo(args.getPseudo());
		if(passwordEncoder.matches(args.getPassword(),user.getPassword())) {
			return user;
		}
		return null;
	}
	
	public boolean verifPassword(long id, String password)
	{
		Optional<User> userOption = findById(id);
		if(userOption.isPresent()) {
			User user = userOption.get();
			return passwordEncoder.matches(password, user.getPassword());
		}
		return false;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	public Optional<User> findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	public void deleteById(long id) {
		userRepository.deleteById(id);
	}
	
	@Override
    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
        Objects.requireNonNull(pseudo);
        User user = userRepository.findByPseudo(pseudo)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }

}
