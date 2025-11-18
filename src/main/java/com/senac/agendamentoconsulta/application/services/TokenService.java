package com.senac.agendamentoconsulta.application.services;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.senac.agendamentoconsulta.application.dtos.LoginRequestDto;
import com.senac.agendamentoconsulta.domain.entities.Token;
import com.senac.agendamentoconsulta.domain.entities.Usuario;
import com.senac.agendamentoconsulta.domain.repositoryes.TokenRepository;
import com.senac.agendamentoconsulta.domain.repositoryes.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Value("${spring.minhapalavrafoda}")
    private String secret;

    @Value("${spring.sessao}")
    private Long tempo;

    private final String emissor = "agendamento-api";

    public String gerarToken(LoginRequestDto loginRequestDTO) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        var usuario = usuarioRepository.findByEmail(loginRequestDTO.email())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        LocalDateTime dataExpiracao = gerarDataExpiracao();

        String token = JWT.create()
                .withIssuer(emissor)
                .withSubject(loginRequestDTO.email())
                .withExpiresAt(
                        dataExpiracao.plusHours(15)
                                .toInstant(ZoneOffset.of("-03:00"))
                )
                .sign(algorithm);

        salvarToken(token, dataExpiracao, usuario);
        return token;
    }

    public String validarToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(emissor)
                .build();

        DecodedJWT decoded = verifier.verify(token);

        return decoded.getSubject(); // AGORA RETORNA STRING
    }

    private LocalDateTime gerarDataExpiracao() {
        return LocalDateTime.now().plusMinutes(tempo);
    }

    public Usuario consultarUsuarioPorToken(String token) throws Exception {
        var tokenBanco = tokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Token não encontrado"));

        if (tokenBanco.getDataExpiracao().isBefore(LocalDateTime.now())) {
            throw new Exception("Token expirado!");
        }

        tokenBanco.setDataExpiracao(LocalDateTime.now().plusMinutes(tempo));
        tokenRepository.save(tokenBanco);

        return tokenBanco.getUsuario();
    }

    public void salvarToken(String token, LocalDateTime dataExpiracao, Usuario usuario) {
        Token tokenBanco = new Token();
        tokenBanco.setToken(token);
        tokenBanco.setDataExpiracao(dataExpiracao);
        tokenBanco.setUsuario(usuario);
        tokenRepository.save(tokenBanco);
    }
}

