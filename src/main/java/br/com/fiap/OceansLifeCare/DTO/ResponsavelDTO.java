package br.com.fiap.OceansLifeCare.DTO;

import br.com.fiap.OceansLifeCare.Controller.ResponsavelController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@Getter
@Setter
public class ResponsavelDTO {

    private Long id;
    private String responsavel;
    private String usuario;
    private String senha;
    private String email;
    private Long telefone;

    public static EntityModel<ResponsavelDTO> toModel(ResponsavelDTO responsavel){
        Link selfLink = WebMvcLinkBuilder.linkTo(ResponsavelController.class)
                .slash(responsavel.getId())
                .withSelfRel();

        Link getAllLink = WebMvcLinkBuilder.linkTo(ResponsavelController.class)
                .withRel("getAll");

        Link getByIdLink = WebMvcLinkBuilder.linkTo(ResponsavelController.class)
                .slash(responsavel.getId())
                .withRel("getById");

        Link createLink = WebMvcLinkBuilder.linkTo(ResponsavelController.class)
                .withRel("create");

        Link updateLink = WebMvcLinkBuilder.linkTo(ResponsavelController.class)
                .slash(responsavel.getId())
                .withRel("update");

        Link deleteLink = WebMvcLinkBuilder.linkTo(ResponsavelController.class)
                .slash(responsavel.getId())
                .withRel("delete");

        return EntityModel.of(responsavel, selfLink, getAllLink, getByIdLink, createLink, updateLink, deleteLink);
    }
}
