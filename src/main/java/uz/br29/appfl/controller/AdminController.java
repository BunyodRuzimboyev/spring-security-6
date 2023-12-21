package uz.br29.appfl.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity sayHello(){
        return ResponseEntity.ok("Admin say hello");
    }

}
