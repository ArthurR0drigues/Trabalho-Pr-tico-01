package br.cefetmg.gestaoentregasentidades.entidades;

import br.cefetmg.gestaoentregasentidades.entidades.enums.TipoPerfil;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "perfil")
public class PerfilEntidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private FuncionarioEntidade funcionario;
    
    @Enumerated(EnumType.STRING)
    private TipoPerfil tipoPerfil;

    public PerfilEntidade() {}

    public PerfilEntidade(int id, FuncionarioEntidade funcionario, TipoPerfil tipoPerfil) {
        this.id = id;
        this.funcionario = funcionario;
        this.tipoPerfil = tipoPerfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FuncionarioEntidade getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioEntidade funcionario) {
        this.funcionario = funcionario;
    }

    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }
}
