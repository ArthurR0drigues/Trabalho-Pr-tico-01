package br.cefetmg.gestaoentregasentidades.entidades;

import br.cefetmg.gestaoentregasentidades.entidades.Funcionario;
import br.cefetmg.gestaoentregasentidades.entidades.enums.TipoPerfil;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-28T22:42:46", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Perfil.class)
public class Perfil_ { 

    public static volatile SingularAttribute<Perfil, TipoPerfil> tipoPerfil;
    public static volatile SingularAttribute<Perfil, Integer> id;
    public static volatile SingularAttribute<Perfil, Funcionario> funcionario;

}