package br.com.fiap.OceansLifeCare.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsavelDTO {

    private Long id;
    private String responsavel;
    private String usuario;
    private String senha;
    private String email;
    private int telefone;
}
