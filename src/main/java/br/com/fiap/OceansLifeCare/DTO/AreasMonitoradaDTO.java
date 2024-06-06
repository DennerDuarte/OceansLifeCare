package br.com.fiap.OceansLifeCare.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AreasMonitoradaDTO {

    private Long id;
    private String nomeArea;
    private int latitude;
    private int longitude;
    private int raio;
    private String dsArea;
    private Long idResponsavel;
    private List<Long> idDeteccoes;
    private List<Long> idInformacoesAmbiente;
}
