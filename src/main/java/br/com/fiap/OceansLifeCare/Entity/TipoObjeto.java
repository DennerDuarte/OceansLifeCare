package br.com.fiap.OceansLifeCare.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="T_TIPOS_OBJETOS")
public class TipoObjeto {

    @Id
    @Column(name="ID_TIPO_OBJETO")
    private Long id;

    @NotNull(message = "O nome do objeto é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome do objeto deve ter entre 3 e 100 caracteres.")
    @Column(name = "NM_OBJETO")
    private String nomeObjeto;

    @NotNull(message = "A descrição do objeto é obrigatória.")
    @Size(min = 10, max = 255, message = "A descrição do objeto deve ter entre 10 e 255 caracteres.")
    @Column(name = "DS_OBJETO")
    private String descObjeto;

    /*@OneToMany(mappedBy = "tipo")
    private List<Deteccao> deteccoes;*/
}
