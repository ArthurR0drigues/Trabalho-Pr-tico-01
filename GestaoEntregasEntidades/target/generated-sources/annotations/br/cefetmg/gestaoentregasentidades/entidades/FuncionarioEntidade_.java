package br.cefetmg.gestaoentregasentidades.entidades;

import br.cefetmg.gestaoentregasentidades.entidades.EmpresaEntidade;
import br.cefetmg.gestaoentregasentidades.entidades.PedidoEntidade;
import br.cefetmg.gestaoentregasentidades.entidades.PerfilEntidade;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-19T07:35:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(FuncionarioEntidade.class)
public class FuncionarioEntidade_ { 

    public static volatile ListAttribute<FuncionarioEntidade, PerfilEntidade> perfis;
    public static volatile SingularAttribute<FuncionarioEntidade, String> senha;
    public static volatile SingularAttribute<FuncionarioEntidade, String> telefone;
    public static volatile SingularAttribute<FuncionarioEntidade, String> nome;
    public static volatile SingularAttribute<FuncionarioEntidade, Integer> id;
    public static volatile ListAttribute<FuncionarioEntidade, PedidoEntidade> pedidos;
    public static volatile SingularAttribute<FuncionarioEntidade, EmpresaEntidade> empresa;

}