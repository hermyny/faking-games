package fr.hermancia.poec.hermanciagames.restController;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.poec.hermanciagames.DTO.AuthenticationDTO;
import fr.hermancia.poec.hermanciagames.DTO.RegistrationUserDTO;
import fr.hermancia.poec.hermanciagames.entity.User;
import fr.hermancia.poec.hermanciagames.json_views.JsonViews;
import fr.hermancia.poec.hermanciagames.security.JwtService;
import fr.hermancia.poec.hermanciagames.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.List;
import java.util.Map;
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/apis/user")
public class UserRestController {


    private AuthenticationManager authenticationManager;
    private UserService userService;
    private JwtService jwtService;

    @GetMapping
    @JsonView(JsonViews.UserListView.class)
    List<User> findAll() {
        return userService.findAll();
    }


    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/inscription")
    @JsonView(JsonViews.UserProfileView.class)
    public void create(@Valid @RequestBody RegistrationUserDTO registrationUserDTO) {
        this.userService.create(registrationUserDTO);
        System.out.println("Hello, World!");
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/activation")
    public void activate(@Valid @RequestBody Map<String, String> activation) {
        this.userService.activation(activation);

    }

    @PostMapping(path = "/login")
    public Map<String, String> connect(@RequestBody AuthenticationDTO authenticationDTO) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationDTO.username(), authenticationDTO.password())
        );

        if (authenticate.isAuthenticated()) {
            return this.jwtService.generate(authenticationDTO.username());
        }
        return null;


    }
}