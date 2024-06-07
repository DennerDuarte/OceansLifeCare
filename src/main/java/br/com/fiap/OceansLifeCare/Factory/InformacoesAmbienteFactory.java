package br.com.fiap.OceansLifeCare.Factory;

import br.com.fiap.OceansLifeCare.DTO.InformacoesAmbienteDTO;
import br.com.fiap.OceansLifeCare.Entity.InformacoesAmbiente;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InformacoesAmbienteFactory {

    public List<InformacoesAmbienteDTO> toDto(List<InformacoesAmbiente> informacoesAmbientes){
        return Optional.ofNullable(informacoesAmbientes)
                .map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public InformacoesAmbienteDTO toDto(InformacoesAmbiente informacoesAmbiente){
        InformacoesAmbienteDTO dto = new InformacoesAmbienteDTO();
        dto.setId(informacoesAmbiente.getId());
        dto.setIdArea(informacoesAmbiente.getIdArea());
        dto.setTemperatura(informacoesAmbiente.getTemperatura());
        dto.setQualidade(informacoesAmbiente.getQualidade());
        dto.setNivelOxigenio(informacoesAmbiente.getNivelOxigenio());
        dto.setDtMedicao(informacoesAmbiente.getDtMedicao());
        return dto;
    }

    public List<InformacoesAmbiente> toEntity(List<InformacoesAmbienteDTO> informacoesAmbientes){
        return Optional.ofNullable(informacoesAmbientes)
                .map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public InformacoesAmbiente toEntity(InformacoesAmbienteDTO informacoesAmbiente){
        InformacoesAmbiente entity = new InformacoesAmbiente();
        entity.setId(informacoesAmbiente.getId());
        entity.setIdArea(informacoesAmbiente.getIdArea());
        entity.setTemperatura(informacoesAmbiente.getTemperatura());
        entity.setQualidade(informacoesAmbiente.getQualidade());
        entity.setNivelOxigenio(informacoesAmbiente.getNivelOxigenio());
        entity.setDtMedicao(informacoesAmbiente.getDtMedicao());
        return entity;
    }
}
