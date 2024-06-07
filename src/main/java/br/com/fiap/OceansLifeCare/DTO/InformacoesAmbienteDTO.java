package br.com.fiap.OceansLifeCare.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.Date;

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
        Link selfLink = WebMvcLinkBuilder.linkTo(InformacoesAmbienteDTO.class)
                .slash(informacao.getId())
                .withSelfRel();

        Link getAllLink = WebMvcLinkBuilder.linkTo(InformacoesAmbienteDTO.class)
                .withRel("getAll");

        Link getByIdLink = WebMvcLinkBuilder.linkTo(InformacoesAmbienteDTO.class)
                .slash(informacao.getId())
                .withRel("getById");

        Link createLink = WebMvcLinkBuilder.linkTo(InformacoesAmbienteDTO.class)
                .withRel("create");

        Link updateLink = WebMvcLinkBuilder.linkTo(InformacoesAmbienteDTO.class)
                .slash(informacao.getId())
                .withRel("update");

        Link deleteLink = WebMvcLinkBuilder.linkTo(InformacoesAmbienteDTO.class)
                .slash(informacao.getId())
                .withRel("delete");

        return EntityModel.of(informacao, selfLink, getAllLink, getByIdLink, createLink, updateLink, deleteLink);
    }
}
