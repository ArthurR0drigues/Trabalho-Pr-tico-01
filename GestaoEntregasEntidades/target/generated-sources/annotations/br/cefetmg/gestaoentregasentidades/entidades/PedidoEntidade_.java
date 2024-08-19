package br.cefetmg.gestaoentregasentidades.entidades;

import br.cefetmg.gestaoentregasentidades.entidades.ClienteEntidade;
import br.cefetmg.gestaoentregasentidades.entidades.FuncionarioEntidade;
import br.cefetmg.gestaoentregasentidades.entidades.ItemPedidoEntidade;
import br.cefetmg.gestaoentregasentidades.entidades.enums.FormaPagamento;
import br.cefetmg.gestaoentregasentidades.entidades.enums.Status;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-19T07:35:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(PedidoEntidade.class)
public class PedidoEntidade_ { 

    public static volatile SingularAttribute<PedidoEntidade, FormaPagamento> formaPagamento;
    public static volatile SingularAttribute<PedidoEntidade, ClienteEntidade> cliente;
    public static volatile SingularAttribute<PedidoEntidade, String> observacao;
    public static volatile SingularAttribute<PedidoEntidade, Double> valorTotal;
    public static volatile ListAttribute<PedidoEntidade, ItemPedidoEntidade> itemPedidos;
    public static volatile SingularAttribute<PedidoEntidade, Date> dataPedido;
    public static volatile SingularAttribute<PedidoEntidade, Integer> id;
    public static volatile SingularAttribute<PedidoEntidade, FuncionarioEntidade> funcionario;
    public static volatile SingularAttribute<PedidoEntidade, Status> status;

}