package br.cefetmg.gestaoentregasentidades.entidades;

import br.cefetmg.gestaoentregasentidades.entidades.ClienteEntidade;
import br.cefetmg.gestaoentregasentidades.entidades.FuncionarioEntidade;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-19T07:35:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(EmpresaEntidade.class)
public class EmpresaEntidade_ { 

    public static volatile SingularAttribute<EmpresaEntidade, String> CPF;
    public static volatile SingularAttribute<EmpresaEntidade, String> nome;
    public static volatile SingularAttribute<EmpresaEntidade, String> CNPJ;
    public static volatile SingularAttribute<EmpresaEntidade, Double> porcentagemComissaoEntregador;
    public static volatile SingularAttribute<EmpresaEntidade, Integer> id;
    public static volatile ListAttribute<EmpresaEntidade, FuncionarioEntidade> funcionarios;
    public static volatile ListAttribute<EmpresaEntidade, ClienteEntidade> clientes;

}