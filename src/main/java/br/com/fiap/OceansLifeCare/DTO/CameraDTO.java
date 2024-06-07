package br.com.fiap.OceansLifeCare.DTO;

import br.com.fiap.OceansLifeCare.Controller.CameraController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.Date;

@Getter
@Setter
public class CameraDTO {

    private Long id;
    private Double latitude;
    private Double longitude;
    private Date dataInstalacao;
    private Date dataUltimaManutecao;
    private String status;

    public static EntityModel<CameraDTO> toModel(CameraDTO camera){
        Link selfLink = WebMvcLinkBuilder.linkTo(CameraController.class)
                .slash(camera.getId())
                .withSelfRel();

        Link getAllLink = WebMvcLinkBuilder.linkTo(CameraController.class)
                .withRel("getAll");

        Link getByIdLink = WebMvcLinkBuilder.linkTo(CameraController.class)
                .slash(camera.getId())
                .withRel("getById");

        Link createLink = WebMvcLinkBuilder.linkTo(CameraController.class)
                .withRel("create");

        Link updateLink = WebMvcLinkBuilder.linkTo(CameraController.class)
                .slash(camera.getId())
                .withRel("update");

        Link deleteLink = WebMvcLinkBuilder.linkTo(CameraController.class)
                .slash(camera.getId())
                .withRel("delete");

        return EntityModel.of(camera, selfLink, getAllLink, getByIdLink, createLink, updateLink, deleteLink);
    }
}
