package br.cefetmg.gestaoentregasentidades.entidades;

import br.cefetmg.gestaoentregasentidades.entidades.ItemPedidoEntidade;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-19T07:35:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ProdutoEntidade.class)
public class ProdutoEntidade_ { 

    public static volatile SingularAttribute<ProdutoEntidade, String> marca;
    public static volatile SingularAttribute<ProdutoEntidade, String> localizacao;
    public static volatile SingularAttribute<ProdutoEntidade, ItemPedidoEntidade> itemPedido;
    public static volatile SingularAttribute<ProdutoEntidade, String> nome;
    public static volatile SingularAttribute<ProdutoEntidade, Integer> id;

}