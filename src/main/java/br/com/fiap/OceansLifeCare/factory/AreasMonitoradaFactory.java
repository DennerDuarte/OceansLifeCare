package br.com.fiap.OceansLifeCare.factory;


import br.com.fiap.OceansLifeCare.DTO.AreasMonitoradaDTO;
import br.com.fiap.OceansLifeCare.Entity.AreasMonitoradas;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AreasMonitoradaFactory {


    public List<AreasMonitoradaDTO> toDto(List<AreasMonitoradas> areas){
        return Optional.ofNullable(areas)
                .map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public AreasMonitoradaDTO toDto(AreasMonitoradas area){
        AreasMonitoradaDTO dto = new AreasMonitoradaDTO();
        dto.setId(area.getId());
        dto.setIdResponsavel(area.getIdResponsavel());
        dto.setNomeArea(area.getNomeArea());
        dto.setLatitude(area.getLatitude());
        dto.setLongitude(area.getLongitude());
        dto.setRaio(area.getRaio());
        dto.setDsArea(area.getDsArea());
        return dto;
    }

    public List<AreasMonitoradas> toEntity(List<AreasMonitoradaDTO> areas){
        return Optional.ofNullable(areas)
                .map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public AreasMonitoradas toEntity(AreasMonitoradaDTO area){
        AreasMonitoradas entity = new AreasMonitoradas();
        entity.setId(area.getId());
        entity.setIdResponsavel(area.getIdResponsavel());
        entity.setNomeArea(area.getNomeArea());
        entity.setLatitude(area.getLatitude());
        entity.setLongitude(area.getLongitude());
        entity.setRaio(area.getRaio());
        entity.setDsArea(area.getDsArea());
        return entity;
    }

}
