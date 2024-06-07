package br.com.fiap.OceansLifeCare.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class InicioController {
	
    @GetMapping()
    public ResponseEntity<String> inicio(){
        return ResponseEntity.ok("Sistema de monitoramento de plantações oceânicas");
    }

}
