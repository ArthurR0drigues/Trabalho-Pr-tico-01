package br.cefetmg.gestaoentregasentidades.entidades;

import br.cefetmg.gestaoentregasentidades.entidades.Empresa;
import br.cefetmg.gestaoentregasentidades.entidades.Pedido;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-02T07:40:40", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> telefone;
    public static volatile SingularAttribute<Cliente, String> logradouro;
    public static volatile SingularAttribute<Cliente, String> bairro;
    public static volatile SingularAttribute<Cliente, String> CPF;
    public static volatile SingularAttribute<Cliente, String> nome;
    public static volatile SingularAttribute<Cliente, String> CNPJ;
    public static volatile SingularAttribute<Cliente, Integer> id;
    public static volatile ListAttribute<Cliente, Pedido> pedidos;
    public static volatile SingularAttribute<Cliente, Empresa> empresa;

}