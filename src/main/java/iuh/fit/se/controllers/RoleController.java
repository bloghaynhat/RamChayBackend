package iuh.fit.se.controllers;

import iuh.fit.se.entities.Role;
import iuh.fit.se.repositories.RoleRepository;
import iuh.fit.se.services.RoleService;
import iuh.fit.se.services.impl.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class RoleController {
    private final RoleServiceImpl roleServiceImpl;

    @GetMapping
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok(roleServiceImpl.getRoles());
    }

}
