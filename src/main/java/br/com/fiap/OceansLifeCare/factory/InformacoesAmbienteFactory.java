package br.com.fiap.OceansLifeCare.factory;

import br.com.fiap.OceansLifeCare.DTO.InformacoesAmbienteDTO;
import br.com.fiap.OceansLifeCare.Entity.InformacoesAmbiente;

public class InformacoesAmbienteFactory {

    public static InformacoesAmbienteDTO toDto(InformacoesAmbiente informacoesAmbiente) {
        if (informacoesAmbiente == null) {
            return null;
        }

        InformacoesAmbienteDTO dto = new InformacoesAmbienteDTO();
        dto.setId(informacoesAmbiente.getId());
        dto.setDtMedicao(informacoesAmbiente.getDtMedicao());
        dto.setNivelOxigenio(informacoesAmbiente.getNivelOxigenio());
        dto.setQualidade(informacoesAmbiente.getQualidade());
        dto.setTemperatura(informacoesAmbiente.getTemperatura());
        dto.setIdAreaMonitorada(informacoesAmbiente.getAreasMonitorada().getId());
        return dto;
    }
}
