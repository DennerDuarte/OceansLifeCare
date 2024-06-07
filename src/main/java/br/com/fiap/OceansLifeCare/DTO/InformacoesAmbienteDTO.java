package br.com.fiap.OceansLifeCare.DTO;

import java.util.Date;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.fiap.OceansLifeCare.Controller.InformacoesAmbienteController;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformacoesAmbienteDTO {

    private Long id;
    private Date dtMedicao;
    private Double nivelOxigenio;
    private String qualidade;
    private Double temperatura;
    private Long idArea;

    public static EntityModel<InformacoesAmbienteDTO> toModel(InformacoesAmbienteDTO informacao){
        Link selfLink = WebMvcLinkBuilder.linkTo(InformacoesAmbienteController.class)
                .slash(informacao.getId())
                .withSelfRel();

        Link getAllLink = WebMvcLinkBuilder.linkTo(InformacoesAmbienteController.class)
                .withRel("getAll");

        Link getByIdLink = WebMvcLinkBuilder.linkTo(InformacoesAmbienteController.class)
                .slash(informacao.getId())
                .withRel("getById");

        Link createLink = WebMvcLinkBuilder.linkTo(InformacoesAmbienteController.class)
                .withRel("create");

        Link updateLink = WebMvcLinkBuilder.linkTo(InformacoesAmbienteController.class)
                .slash(informacao.getId())
                .withRel("update");

        Link deleteLink = WebMvcLinkBuilder.linkTo(InformacoesAmbienteController.class)
                .slash(informacao.getId())
                .withRel("delete");

        return EntityModel.of(informacao, selfLink, getAllLink, getByIdLink, createLink, updateLink, deleteLink);
    }
}
