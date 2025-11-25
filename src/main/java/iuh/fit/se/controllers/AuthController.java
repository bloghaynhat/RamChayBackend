package iuh.fit.se.controllers;

import com.nimbusds.jose.JOSEException;
import iuh.fit.se.dtos.request.CustomerRegistrationRequest;
import iuh.fit.se.dtos.request.LoginRequest;
import iuh.fit.se.dtos.response.ApiResponse;
import iuh.fit.se.dtos.response.CustomerRegistrationResponse;
import iuh.fit.se.dtos.response.LoginResponse;
import iuh.fit.se.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse<CustomerRegistrationResponse> register(@RequestBody CustomerRegistrationRequest request) {
        return ApiResponse.<CustomerRegistrationResponse>builder()
                .result(authService.register(request))
                .build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) throws JOSEException {
        LoginResponse loginResponse = authService.login(request);
        String refreshToken = loginResponse.getRefreshToken();
        String accessToken = loginResponse.getAccessToken();

        ResponseCookie accessCookie = ResponseCookie.from("accessToken", accessToken)
                .httpOnly(true)  // Quan trọng: JS không đọc được
                .secure(false)   // True nếu chạy https (Production), False nếu chạy localhost
                .path("/")       // Cookie có hiệu lực toàn server
                .maxAge(60 * 60) // 1 giờ cho accessToken
                .sameSite("Lax") // Hoặc "None" nếu khác domain, "Lax" nếu cùng domain/subdomain
                .build();

        ResponseCookie refreshCookie = ResponseCookie.from("refreshToken", refreshToken)
                .httpOnly(true)  // Quan trọng: JS không đọc được
                .secure(false)   // True nếu chạy https (Production), False nếu chạy localhost
                .path("/")       // Cookie có hiệu lực toàn server
                .maxAge(7 * 24 * 60 * 60) // 7 ngày cho refreshToken
                .sameSite("Lax") // Hoặc "None" nếu khác domain, "Lax" nếu cùng domain/subdomain
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, refreshCookie.toString())
                .header(HttpHeaders.SET_COOKIE, accessCookie.toString())
                .body(ApiResponse.<LoginResponse>builder()
                        .result(loginResponse)
                        .build());
    }
}
