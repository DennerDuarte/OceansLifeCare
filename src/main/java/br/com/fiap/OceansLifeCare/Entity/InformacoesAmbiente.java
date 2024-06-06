package br.com.fiap.OceansLifeCare.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="T_INFORMACOES_AMBIENTE")
public class InformacoesAmbiente {

    @Id
    @Column(name="ID_INFORMACAO")
    private Long id;

    @NotNull(message = "O Id da Area é obrigatório")
    @Column(name = "ID_AREA")
    private Long idArea;

    @NotNull(message = "A data de medição é obrigatória.")
    @Column(name = "DT_MEDICAO")
    private Date dtMedicao;

    @NotNull(message = "O nível de oxigênio é obrigatório.")
    @Column(name = "NR_NIVEL_OXIGENIO")
    private Double nivelOxigenio;

    @NotNull(message = "A qualidade é obrigatória.")
    @Size(max = 2, message = "A qualidade deve ter até 2 caracteres.")
    @Column(name = "DS_QUALIDADE")
    private String qualidade;

    @NotNull(message = "A temperatura é obrigatória.")
    @Column(name = "NR_TEMPERATURA")
    private Double temperatura;


}
