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
@Table(name="T_CAMERAS")
public class Camera {

    @Id
    @Column(name="ID_CAMERA")
    private Long id;

    @NotNull(message = "A latitude é obrigatória.")
    @Column(name = "NR_LATITUDE")
    private Double latitude;

    @NotNull(message = "A longitude é obrigatória.")
    @Column(name = "NR_LONGITUDE")
    private Double longitude;

    @NotNull(message = "A data de instalação é obrigatória.")
    @Column(name = "DT_INSTALACAO")
    private Date dataInstalacao;

    @NotNull(message = "A data da última manutenção é obrigatória.")
    @Column(name = "DT_ULT_MANUTENCAO")
    private Date dataUltimaManutecao;

    @NotNull(message = "O status é obrigatório.")
    @Size(max = 2, message = "O status deve ter até 2 caracteres.")
    @Column(name = "DS_STATUS")
    private String status;

    //@OneToMany(mappedBy = "camera")
    //private List<Deteccao> deteccao;
}
