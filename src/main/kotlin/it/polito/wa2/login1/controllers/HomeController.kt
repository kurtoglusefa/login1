package it.polito.wa2.login1.controllers

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime


@RestController
class HomeController {
    @GetMapping("/")
    fun home() = mapOf(
        "message" to "Welcome to the login service",
        "version" to "1.0.0",
        "data" to LocalDateTime.now()
    )
    @GetMapping("/me")
    fun me(authentication: Authentication)=mapOf(
        "username" to authentication.principal as? org.springframework.security.oauth2.core.oidc.user.OidcUser,
        "authorities" to authentication.authorities.map { it.authority },
    )
}