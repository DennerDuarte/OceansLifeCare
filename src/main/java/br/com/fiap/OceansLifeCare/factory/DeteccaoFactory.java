package br.com.fiap.OceansLifeCare.factory;

import br.com.fiap.OceansLifeCare.DTO.DeteccaoDTO;
import br.com.fiap.OceansLifeCare.Entity.Deteccao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DeteccaoFactory {

    public List<DeteccaoDTO> toDto(List<Deteccao> deteccoes){
        return Optional.ofNullable(deteccoes)
                .map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public DeteccaoDTO toDto(Deteccao deteccao){
        DeteccaoDTO dto = new DeteccaoDTO();
        dto.setId(deteccao.getId());
        dto.setIdCamera(deteccao.getIdCamera());
        dto.setIdArea(deteccao.getIdArea());
        dto.setIdTipoObjeto(deteccao.getIdTipoObjeto());
        dto.setDataDeteccao(deteccao.getDataDeteccao());
        dto.setNivelConfianca(deteccao.getNivelConfianca());
        dto.setStatus(deteccao.getStatus());
        return dto;
    }

    public List<Deteccao> toEntity(List<DeteccaoDTO> deteccoes){
        return Optional.ofNullable(deteccoes)
                .map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public Deteccao toEntity(DeteccaoDTO deteccao){
        Deteccao entity = new Deteccao();
        entity.setId(deteccao.getId());
        entity.setIdCamera(deteccao.getIdCamera());
        entity.setIdArea(deteccao.getIdArea());
        entity.setIdTipoObjeto(deteccao.getIdTipoObjeto());
        entity.setDataDeteccao(deteccao.getDataDeteccao());
        entity.setNivelConfianca(deteccao.getNivelConfianca());
        entity.setStatus(deteccao.getStatus());
        return entity;
    }

}
