package br.com.fiap.OceansLifeCare.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AreasMonitoradaDTO {

    private Long id;
    private String nomeArea;
    private Double latitude;
    private Double longitude;
    private Integer raio;
    private String dsArea;
    private Long idResponsavel;
    //private List<DeteccaoDTO> deteccoes;
    private List<InformacoesAmbienteDTO> informacoesAmbiente;
}
