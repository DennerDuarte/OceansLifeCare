package br.com.fiap.OceansLifeCare.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="T_RESPONSAVEIS")
public class Responsavel {

    @Id
    @Column(name="ID_RESPONSAVEL")
    private Long id;

    @NotNull(message = "O nome do responsável é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome do responsável deve ter entre 3 e 100 caracteres.")
    @Column(name = "NM_RESPONSAVEL")
    private String responsavel;

    @NotNull(message = "O nome de usuário é obrigatório.")
    @Size(min = 3, max = 20, message = "O nome de usuário deve ter entre 3 e 20 caracteres.")
    @Column(name = "DS_USUARIO")
    private String usuario;

    @NotNull(message = "A senha é obrigatória.")
    @Size(min = 3, max = 255, message = "A senha deve ter entre 3 e 255 caracteres.")
    @Column(name = "DS_SENHA")
    private String senha;

    @NotNull(message = "O email é obrigatório.")
    @Size(min = 3, max = 100, message = "O email eve ter entre 3 e 100 caracteres.")
    @Column(name = "DS_EMAIL")
    private String email;

    @NotNull(message = "O telefone é obrigatório.")
    @Column(name = "NR_TELEFONE")
    private int telefone;

    @OneToMany(mappedBy = "responsavel")
    private List<AreasMonitoradas> areasMonitoradas;
}
