package br.com.fiap.OceansLifeCare.factory;

import br.com.fiap.OceansLifeCare.DTO.ResponsavelDTO;
import br.com.fiap.OceansLifeCare.Entity.Responsavel;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ResponsavelFactory {

    public List<ResponsavelDTO> toDto(List<Responsavel> responsaveis){
        return Optional.ofNullable(responsaveis)
                .map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public ResponsavelDTO toDto( Responsavel responsavel){
        ResponsavelDTO dto = new ResponsavelDTO();
        dto.setId(responsavel.getId());
        dto.setResponsavel(responsavel.getResponsavel());
        dto.setUsuario(responsavel.getUsuario());
        dto.setSenha(responsavel.getSenha());
        dto.setEmail(responsavel.getEmail());
        dto.setTelefone(responsavel.getTelefone());
        return dto;
    }

    public List<ResponsavelDTO> toEntity(List<Responsavel> responsaveis){
        return Optional.ofNullable(responsaveis)
                .map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public ResponsavelDTO toEntity( Responsavel responsavel){
        ResponsavelDTO dto = new ResponsavelDTO();
        dto.setId(responsavel.getId());
        dto.setResponsavel(responsavel.getResponsavel());
        dto.setUsuario(responsavel.getUsuario());
        dto.setSenha(responsavel.getSenha());
        dto.setEmail(responsavel.getEmail());
        dto.setTelefone(responsavel.getTelefone());
        return dto;
    }

}
