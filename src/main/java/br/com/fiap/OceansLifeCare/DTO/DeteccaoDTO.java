package br.com.fiap.OceansLifeCare.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DeteccaoDTO {

    private Long id;
    private Date dataDeteccao;
    private double nivelConfianca;
    private String status;
    private Long idCamera;
    private Long idArea;
    private Long idTipoObjeto;
}
