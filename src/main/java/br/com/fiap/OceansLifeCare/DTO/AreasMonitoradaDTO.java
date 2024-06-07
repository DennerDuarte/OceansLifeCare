package br.com.fiap.OceansLifeCare.DTO;

import br.com.fiap.OceansLifeCare.Controller.AreaMonitoradaController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

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

    public static EntityModel<AreasMonitoradaDTO> toModel(AreasMonitoradaDTO area){
        Link selfLink = WebMvcLinkBuilder.linkTo(AreaMonitoradaController.class)
                .slash(area.getId())
                .withSelfRel();

        Link getAllLink = WebMvcLinkBuilder.linkTo(AreasMonitoradaDTO.class)
                .withRel("getAll");

        Link getByIdLink = WebMvcLinkBuilder.linkTo(AreasMonitoradaDTO.class)
                .slash(area.getId())
                .withRel("getById");

        Link createLink = WebMvcLinkBuilder.linkTo(AreasMonitoradaDTO.class)
                .withRel("create");

        Link updateLink = WebMvcLinkBuilder.linkTo(AreasMonitoradaDTO.class)
                .slash(area.getId())
                .withRel("update");

        Link deleteLink = WebMvcLinkBuilder.linkTo(AreasMonitoradaDTO.class)
                .slash(area.getId())
                .withRel("delete");

        return EntityModel.of(area, selfLink, getAllLink, getByIdLink, createLink, updateLink, deleteLink);
    }
}
