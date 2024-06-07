package br.com.fiap.OceansLifeCare.Factory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.fiap.OceansLifeCare.DTO.AreasMonitoradasDTO;
import br.com.fiap.OceansLifeCare.Entity.AreasMonitoradas;

public class AreasMonitoradasFactory {

	InformacoesAmbienteFactory informacoesAmbienteFactory = new InformacoesAmbienteFactory();

    public List<AreasMonitoradasDTO> toDto(List<AreasMonitoradas> areas){
        return Optional.ofNullable(areas)
                .map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public AreasMonitoradasDTO toDto(AreasMonitoradas area){
        AreasMonitoradasDTO dto = new AreasMonitoradasDTO();
        dto.setId(area.getId());
        dto.setIdResponsavel(area.getIdResponsavel());
        dto.setNomeArea(area.getNomeArea());
        dto.setLatitude(area.getLatitude());
        dto.setLongitude(area.getLongitude());
        dto.setRaio(area.getRaio());
        dto.setDsArea(area.getDsArea());
        dto.setInformacoesAmbiente(informacoesAmbienteFactory.toDto(area.getInformacoesAmbientes()));
        return dto;
    }

    public List<AreasMonitoradas> toEntity(List<AreasMonitoradasDTO> areas){
        return Optional.ofNullable(areas)
                .map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public AreasMonitoradas toEntity(AreasMonitoradasDTO area){
        AreasMonitoradas entity = new AreasMonitoradas();
        entity.setId(area.getId());
        entity.setIdResponsavel(area.getIdResponsavel());
        entity.setNomeArea(area.getNomeArea());
        entity.setLatitude(area.getLatitude());
        entity.setLongitude(area.getLongitude());
        entity.setRaio(area.getRaio());
        entity.setDsArea(area.getDsArea());
        entity.setInformacoesAmbientes(informacoesAmbienteFactory.toEntity(area.getInformacoesAmbiente()));
        return entity;
    }

}
