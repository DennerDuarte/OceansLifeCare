package br.com.fiap.OceansLifeCare.Factory;

import br.com.fiap.OceansLifeCare.DTO.TipoObjetoDTO;
import br.com.fiap.OceansLifeCare.Entity.TipoObjeto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TipoObjetoFactory {

    public List<TipoObjetoDTO> toDto(List<TipoObjeto> tipoObjetos){
        return Optional.ofNullable(tipoObjetos)
                .map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }
    public  TipoObjetoDTO toDto(TipoObjeto tipoObjeto) {

        TipoObjetoDTO dto = new TipoObjetoDTO();
        dto.setId(tipoObjeto.getId());
        dto.setNomeObjeto(tipoObjeto.getNomeObjeto());
        dto.setDescObjeto(tipoObjeto.getDescObjeto());
        return dto;
    }

    public List<TipoObjeto> toEntity(List<TipoObjetoDTO> tipoObjetos){
        return Optional.ofNullable(tipoObjetos)
                .map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }
    public  TipoObjeto toEntity(TipoObjetoDTO tipoObjeto) {

        TipoObjeto entity = new TipoObjeto();
        entity.setId(tipoObjeto.getId());
        entity.setNomeObjeto(tipoObjeto.getNomeObjeto());
        entity.setDescObjeto(tipoObjeto.getDescObjeto());
        return entity;
    }

}
