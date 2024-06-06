package br.com.fiap.OceansLifeCare.factory;

import br.com.fiap.OceansLifeCare.DTO.CameraDTO;
import br.com.fiap.OceansLifeCare.Entity.Camera;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CameraFactory {

    public List<CameraDTO> toDto(List<Camera> cameras){
        return Optional.ofNullable(cameras)
                .map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public CameraDTO toDto(Camera camera){
        CameraDTO dto = new CameraDTO();
        dto.setId(camera.getId());
        dto.setLatitude(camera.getLatitude());
        dto.setLongitude(camera.getLongitude());
        dto.setDataInstalacao(camera.getDataInstalacao());
        dto.setDataUltimaManutecao(camera.getDataUltimaManutecao());
        dto.setStatus(camera.getStatus());
        return dto;
    }

    public List<CameraDTO> toEntity(List<Camera> cameras){
        return Optional.ofNullable(cameras)
                .map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public CameraDTO toEntity(Camera camera){
        CameraDTO dto = new CameraDTO();
        dto.setId(camera.getId());
        dto.setLatitude(camera.getLatitude());
        dto.setLongitude(camera.getLongitude());
        dto.setDataInstalacao(camera.getDataInstalacao());
        dto.setDataUltimaManutecao(camera.getDataUltimaManutecao());
        dto.setStatus(camera.getStatus());
        return dto;
    }

}
