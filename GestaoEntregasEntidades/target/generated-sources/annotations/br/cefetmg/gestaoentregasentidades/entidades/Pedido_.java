package br.cefetmg.gestaoentregasentidades.entidades;

import br.cefetmg.gestaoentregasentidades.entidades.Cliente;
import br.cefetmg.gestaoentregasentidades.entidades.Funcionario;
import br.cefetmg.gestaoentregasentidades.entidades.ItemPedido;
import br.cefetmg.gestaoentregasentidades.entidades.enums.FormaPagamento;
import br.cefetmg.gestaoentregasentidades.entidades.enums.Status;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-28T22:42:46", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, FormaPagamento> formaPagamento;
    public static volatile SingularAttribute<Pedido, Cliente> cliente;
    public static volatile SingularAttribute<Pedido, String> observacao;
    public static volatile SingularAttribute<Pedido, Double> valorTotal;
    public static volatile ListAttribute<Pedido, ItemPedido> itemPedidos;
    public static volatile SingularAttribute<Pedido, Date> dataPedido;
    public static volatile SingularAttribute<Pedido, Integer> id;
    public static volatile SingularAttribute<Pedido, Funcionario> funcionario;
    public static volatile SingularAttribute<Pedido, Status> status;

}