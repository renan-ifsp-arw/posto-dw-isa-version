package br.edu.ifsp.ar.postodw.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "bomba")
@Getter @Setter
@NoArgsConstructor
public class Bomba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Combustivel combustivel;

    @NotNull
    @DecimalMin(value = "0,0")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal preco;

    @NotNull
    @DecimalMin(value = "0,0")
    @Digits(integer = 10, fraction = 2)
    @Column(name = "quantidade_atual")
    private BigDecimal quantidadeAtual;

    @NotNull
    @DecimalMin(value = "0,0")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal capacidade;
}
