package br.edu.ifsp.ar.postodw.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ordem_compra")
@Getter @Setter
@NoArgsConstructor
public class OrdemCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "data_compra")
    private LocalDate dataCompra;

    @NotNull
    @DecimalMin(value = "0,0")
    @Digits(integer = 10, fraction = 2, message = "O valor deve ter no máximo 10 dígitos e 2 casas decimais")
    private BigDecimal valorTotal;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedor fornecedor;

    @NotNull
    @Size(min = 3, max = 255, message = "O produto deve ter entre 3 e 255 caracteres")
    private String produto;

    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoOrdem tipo;

    public enum TipoOrdem {
        COMBUSTIVEL, CONVENIENCIA;
    }
}
