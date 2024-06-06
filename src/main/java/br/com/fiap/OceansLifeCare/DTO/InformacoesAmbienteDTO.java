package br.com.fiap.OceansLifeCare.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InformacoesAmbienteDTO {

    private Long id;
    private Date dtMedicao;
    private double nivelOxigenio;
    private String qualidade;
    private double temperatura;
    private Long idAreaMonitorada;
}
