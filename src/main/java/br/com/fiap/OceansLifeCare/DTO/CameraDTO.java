package br.com.fiap.OceansLifeCare.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CameraDTO {

    private Long id;
    private int latitude;
    private int longitude;
    private Date dataInstalacao;
    private Date dataUltimaManutecao;
    private String status;
}
