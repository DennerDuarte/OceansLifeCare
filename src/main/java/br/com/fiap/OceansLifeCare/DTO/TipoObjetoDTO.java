package br.com.fiap.OceansLifeCare.DTO;

import br.com.fiap.OceansLifeCare.Controller.AreaMonitoradaController;
import br.com.fiap.OceansLifeCare.Controller.TipoObjetoController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@Getter
@Setter
public class TipoObjetoDTO {

    private Long id;
    private String nomeObjeto;
    private String descObjeto;

    public static EntityModel<TipoObjetoDTO> toModel(TipoObjetoDTO tipo){
        Link selfLink = WebMvcLinkBuilder.linkTo(TipoObjetoController.class)
                .slash(tipo.getId())
                .withSelfRel();

        Link getAllLink = WebMvcLinkBuilder.linkTo(TipoObjetoController.class)
                .withRel("getAll");

        Link getByIdLink = WebMvcLinkBuilder.linkTo(TipoObjetoController.class)
                .slash(tipo.getId())
                .withRel("getById");

        Link createLink = WebMvcLinkBuilder.linkTo(TipoObjetoController.class)
                .withRel("create");

        Link updateLink = WebMvcLinkBuilder.linkTo(TipoObjetoController.class)
                .slash(tipo.getId())
                .withRel("update");

        Link deleteLink = WebMvcLinkBuilder.linkTo(TipoObjetoController.class)
                .slash(tipo.getId())
                .withRel("delete");

        return EntityModel.of(tipo, selfLink, getAllLink, getByIdLink, createLink, updateLink, deleteLink);
    }
}
