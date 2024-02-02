package fr.hermancia.poec.hermanciagames.service;

import fr.hermancia.poec.hermanciagames.DTO.RegistrationUserDTO;
import fr.hermancia.poec.hermanciagames.entity.User;
import fr.hermancia.poec.hermanciagames.entity.Validation;
import fr.hermancia.poec.hermanciagames.exception.NotFoundHermanciaGamesException;
import fr.hermancia.poec.hermanciagames.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService
        implements
            UserDetailsService,
            DAOServiceInterface<User>
         {

    private UserRepository userRepository;

    private CountryService countryService;

    private BCryptPasswordEncoder passwordEncoder;

    private ValidationService validationService;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


    @Override
    public User getObjectById(Long id) {
        Optional<User> optionalUser = findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundHermanciaGamesException("User", "id", id);
        }
        return optionalUser.get();
    }


    public void create(RegistrationUserDTO registrationDTO) {

        Optional<User> userOptional = this.userRepository.findByEmail(registrationDTO.getEmail());
        if(userOptional.isPresent()) {
            throw new RuntimeException("Veuillez renseigner un autre email");
        }
        User user = new User();
        user.setName(registrationDTO.getName());
        user.setNickname(registrationDTO.getNickname());
        user.setEmail(registrationDTO.getEmail().toLowerCase());
        String password = this.passwordEncoder.encode(registrationDTO.getPassword());
        user.setPassword(password);
        user = this.userRepository.save(user);
        this.validationService.registrate(user);

    }

    public void activation(Map<String, String> activation) {
        Validation validation = this.validationService.readByCode(activation.get("code"));
        if (Instant.now().isAfter(validation.getExpire())) {
            throw new RuntimeException("Votre code a expiré");
        }
        User userActive = this.userRepository.findById(validation
                        .getUser()
                        .getId())
                        .orElseThrow(() ->
                                new RuntimeException("Utilisateur inconnu"));
		userActive.setActive(true);
		this.userRepository.save(userActive);

         }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository
                .findByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Aucun utilisateur ne corespond à cet identifiant"));
        }
    }
