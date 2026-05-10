package uu.app.userservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uu.app.userservice.util.JwtUtil;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    public final JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> user) {
        String username = user.get("username");
        String role = user.get("role");
        String token = jwtUtil.generateToken(username, role);

        return Map.of("token", token);
    }
}
