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
@Table(name="T_DETECCOES")
public class Deteccao {

    @Id
    @Column(name="ID_DETECCAO")
    private Long id;

    @NotNull(message = "A data de detecção é obrigatória.")
    @Column(name = "DT_DETECCAO")
    private Date dataDeteccao;

    @NotNull(message = "O nível de confiança é obrigatório.")
    @Column(name = "NR_NIVEL_CONFIANCA")
    private double nivelConfianca;

    @NotNull(message = "O status é obrigatório.")
    @Size(max = 3, message = "O status deve ter até 3 caracteres.")
    @Column(name = "DS_STATUS")
    private String status;

    @ManyToOne
    @JoinColumn(name="ID_CAMERA", nullable=false)
    private Camera camera;

    @ManyToOne
    @JoinColumn(name="ID_AREA", nullable=false)
    private AreasMonitoradas area;

    @ManyToOne
    @JoinColumn(name="ID_TIPO_OBJETO", nullable=false)
    private TipoObjeto tipo;
}
