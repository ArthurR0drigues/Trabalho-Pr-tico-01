package br.cefetmg.gestaoentregasentidades.entidades;

import br.cefetmg.gestaoentregasentidades.entidades.PedidoEntidade;
import br.cefetmg.gestaoentregasentidades.entidades.ProdutoEntidade;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-19T07:35:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ItemPedidoEntidade.class)
public class ItemPedidoEntidade_ { 

    public static volatile ListAttribute<ItemPedidoEntidade, ProdutoEntidade> produtos;
    public static volatile SingularAttribute<ItemPedidoEntidade, PedidoEntidade> pedido;
    public static volatile SingularAttribute<ItemPedidoEntidade, Integer> id;
    public static volatile SingularAttribute<ItemPedidoEntidade, Integer> quantidade;
    public static volatile SingularAttribute<ItemPedidoEntidade, Double> valorUnitario;

}