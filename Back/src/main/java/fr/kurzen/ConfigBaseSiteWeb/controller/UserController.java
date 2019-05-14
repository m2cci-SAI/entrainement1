package fr.kurzen.ConfigBaseSiteWeb.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.kurzen.ConfigBaseSiteWeb.builder.UserBuilder;
import fr.kurzen.ConfigBaseSiteWeb.exception.UserCudException;
import fr.kurzen.ConfigBaseSiteWeb.exception.UserNotFoundException;
import fr.kurzen.ConfigBaseSiteWeb.model.User;
import fr.kurzen.ConfigBaseSiteWeb.repository.UserRepository;
import fr.kurzen.ConfigBaseSiteWeb.securite.JwtAuthentificationResponse;
import fr.kurzen.ConfigBaseSiteWeb.securite.JwtTokenProvider;
import fr.kurzen.ConfigBaseSiteWeb.securite.Message;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtTokenProvider tokenProvider;
	
	@Autowired
	private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody UserBuilder loginRequest) {
    	BCryptPasswordEncoder crypter = new BCryptPasswordEncoder();
    	crypter.encode(loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getPseudo(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthentificationResponse(jwt));
    }
    
    
	@GetMapping(value = "/")
	public List<User> getUsers() throws UserNotFoundException {
		LinkedList<User> lp = new LinkedList<>();
		Iterable<User> o = userRepository.findAll();
		o.forEach(v -> {
			lp.push(v);
		});
		return lp;
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/byPseudo/{pseudo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserByLogin(@PathVariable("pseudo") String pseudo) throws UserNotFoundException {
		Optional<User> o = userRepository.findByPseudo(pseudo);
		if (!o.isPresent()) {
			throw new UserNotFoundException("Utilisateur introuvable");

		} else {
			return (User) o.get();
		}
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User getUserById(@PathVariable("id") long id) throws UserNotFoundException {
		Optional<User> o = userRepository.findById(id);
		if (!o.isPresent()) {
			throw new UserNotFoundException("Utilisateur introuvable");

		} else {
			return (User) o.get();
		}
	}

	@PostMapping(value = "/")
	public User create(@RequestBody @Valid User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return user;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.PUT, value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public User update(@RequestBody @Valid User user, BindingResult bindingResult) throws UserNotFoundException {
		if (bindingResult.hasErrors()) {
			// gérer ses erreurs
			System.out.println(bindingResult.getErrorCount());
		}
		Optional<User> getUser = userRepository.findById(user.getId());
		User userFromBD;
		if (getUser.isPresent()) {
			userFromBD = userRepository.findById(user.getId()).get();
		} else {
			throw new UserNotFoundException("Poney introuvable");
		}

		userFromBD.setPseudo(user.getPseudo());
		userFromBD.setPassword(user.getPassword());
		userRepository.save(userFromBD);
		return userFromBD;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Message delete(@PathVariable("id") long id) throws UserNotFoundException, UserCudException {
		Optional<User> obsderveAvantDestruction = userRepository.findById(id);

		if (obsderveAvantDestruction.isPresent()) {
			userRepository.deleteById(id);
			Optional<User> obsderveAprestDestruction = userRepository.findById(id);
			if (!obsderveAprestDestruction.isPresent()) {
				return new Message("Élément supprimé", false);
			} else {
				// TODO : Retravailler l'exception
				throw new UserCudException("Echec de l'opération, l'élément n'a pas été supprimé.");
			}

		} else {
			throw new UserNotFoundException("L'élément que vous cherchez à supprimer n'a pas été trouvé.");
		}

	}

}
