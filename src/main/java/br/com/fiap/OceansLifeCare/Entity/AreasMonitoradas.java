package br.com.fiap.OceansLifeCare.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="T_AREAS_MONITORADAS")
public class AreasMonitoradas {

    @Id
    @Column(name="ID_AREA")
    private Long id;

    @NotNull(message = "É necessário informar o Id do responsável.")
    @Column(name="ID_RESPONSAVEL")
    private Long idResponsavel;

    @NotNull(message = "É necessário que o nome da área seja informado.")
    @Size(min = 10, max = 100, message = "É necessário que o nome da área tenha entre 10 e 100 caracteres.")
    @Column(name = "NM_AREA")
    private String nomeArea;

    @NotNull(message = "A latitude é obrigatória.")
    @Column(name = "NR_LATITUDE")
    private int latitude;

    @NotNull(message = "A longitude é obrigatória.")
    @Column(name = "NR_LONGITUDE")
    private int longitude;

    @NotNull(message = "O raio é obrigatório.")
    @Column(name = "NR_RAIO")
    private int raio;

    @NotNull(message = "A descrição da área é obrigatória.")
    @Size(min = 10, max = 255, message = "A descrição da área precisa ter entre 10 e 255 caracteres.")
    @Column(name = "DS_AREA")
    private String dsArea;

    @ManyToOne
    @JoinColumn(name="ID_RESPONSAVEL", nullable=false)
    private Responsavel responsavel;

    @OneToMany(mappedBy = "areaMonitorada")
    private List<Deteccao> deteccoes;

    @OneToMany(mappedBy = "areasMonitorada")
    private List<InformacoesAmbiente> informacoesAmbientes;
}
