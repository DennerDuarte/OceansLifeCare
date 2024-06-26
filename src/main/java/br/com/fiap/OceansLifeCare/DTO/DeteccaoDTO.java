package br.com.fiap.OceansLifeCare.DTO;

import java.util.Date;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.fiap.OceansLifeCare.Controller.DeteccaoController;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeteccaoDTO {

    private Long id;
    private Date dataDeteccao;
    private Double nivelConfianca;
    private String status;
    private Long idCamera;
    private Long idArea;
    private Long idTipoObjeto;
    private CameraDTO camera;
    private AreasMonitoradasDTO area;
    private TipoObjetoDTO tipoObjeto;

    public static EntityModel<DeteccaoDTO> toModel(DeteccaoDTO deteccao){
        Link selfLink = WebMvcLinkBuilder.linkTo(DeteccaoController.class)
                .slash(deteccao.getId())
                .withSelfRel();

        Link getAllLink = WebMvcLinkBuilder.linkTo(DeteccaoController.class)
                .withRel("getAll");

        Link getByIdLink = WebMvcLinkBuilder.linkTo(DeteccaoController.class)
                .slash(deteccao.getId())
                .withRel("getById");

        Link createLink = WebMvcLinkBuilder.linkTo(DeteccaoController.class)
                .withRel("create");

        Link updateLink = WebMvcLinkBuilder.linkTo(DeteccaoController.class)
                .slash(deteccao.getId())
                .withRel("update");

        Link deleteLink = WebMvcLinkBuilder.linkTo(DeteccaoController.class)
                .slash(deteccao.getId())
                .withRel("delete");

        return EntityModel.of(deteccao, selfLink, getAllLink, getByIdLink, createLink, updateLink, deleteLink);
    }
}
