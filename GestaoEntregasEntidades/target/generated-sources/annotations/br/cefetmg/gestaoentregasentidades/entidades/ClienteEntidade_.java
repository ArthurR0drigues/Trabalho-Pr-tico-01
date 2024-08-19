package br.cefetmg.gestaoentregasentidades.entidades;

import br.cefetmg.gestaoentregasentidades.entidades.EmpresaEntidade;
import br.cefetmg.gestaoentregasentidades.entidades.PedidoEntidade;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-19T07:35:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ClienteEntidade.class)
public class ClienteEntidade_ { 

    public static volatile SingularAttribute<ClienteEntidade, String> telefone;
    public static volatile SingularAttribute<ClienteEntidade, String> logradouro;
    public static volatile SingularAttribute<ClienteEntidade, String> bairro;
    public static volatile SingularAttribute<ClienteEntidade, String> CPF;
    public static volatile SingularAttribute<ClienteEntidade, String> nome;
    public static volatile SingularAttribute<ClienteEntidade, String> CNPJ;
    public static volatile SingularAttribute<ClienteEntidade, Integer> id;
    public static volatile ListAttribute<ClienteEntidade, PedidoEntidade> pedidos;
    public static volatile SingularAttribute<ClienteEntidade, EmpresaEntidade> empresa;

}