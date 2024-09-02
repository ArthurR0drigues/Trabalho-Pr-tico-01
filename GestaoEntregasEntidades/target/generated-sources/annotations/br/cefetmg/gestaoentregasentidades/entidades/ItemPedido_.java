package br.cefetmg.gestaoentregasentidades.entidades;

import br.cefetmg.gestaoentregasentidades.entidades.Pedido;
import br.cefetmg.gestaoentregasentidades.entidades.Produto;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-02T07:40:40", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ItemPedido.class)
public class ItemPedido_ { 

    public static volatile ListAttribute<ItemPedido, Produto> produtos;
    public static volatile SingularAttribute<ItemPedido, Pedido> pedido;
    public static volatile SingularAttribute<ItemPedido, Integer> id;
    public static volatile SingularAttribute<ItemPedido, Integer> quantidade;
    public static volatile SingularAttribute<ItemPedido, Double> valorUnitario;

}