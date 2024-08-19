package br.cefetmg.gestaoentregasentidades.entidades;

import br.cefetmg.gestaoentregasentidades.entidades.FuncionarioEntidade;
import br.cefetmg.gestaoentregasentidades.entidades.enums.TipoPerfil;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-19T07:35:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(PerfilEntidade.class)
public class PerfilEntidade_ { 

    public static volatile SingularAttribute<PerfilEntidade, TipoPerfil> tipoPerfil;
    public static volatile SingularAttribute<PerfilEntidade, Integer> id;
    public static volatile SingularAttribute<PerfilEntidade, FuncionarioEntidade> funcionario;

}