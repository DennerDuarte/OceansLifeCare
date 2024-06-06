package br.com.fiap.OceansLifeCare.factory;

import br.com.fiap.OceansLifeCare.DTO.DeteccaoDTO;
import br.com.fiap.OceansLifeCare.Entity.Deteccao;

public class DeteccaoFactory {

    public static DeteccaoDTO toDto(Deteccao deteccao) {
        if (deteccao == null) {
            return null;
        }

        DeteccaoDTO dto = new DeteccaoDTO();
        dto.setId(deteccao.getId());
        dto.setDataDeteccao(deteccao.getDataDeteccao());
        dto.setNivelConfianca(deteccao.getNivelConfianca());
        dto.setStatus(deteccao.getStatus());
        dto.setIdCamera(deteccao.getCamera().getId());
        dto.setIdArea(deteccao.getArea().getId());
        dto.setIdTipoObjeto(deteccao.getTipo().getId());
        return dto;
    }
}
