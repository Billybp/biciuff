package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bicicleta.class)
public abstract class Bicicleta_ {

	public static volatile ListAttribute<Bicicleta, Aluguel> aluguelList;
	public static volatile SingularAttribute<Bicicleta, Boolean> disponivel;
	public static volatile SingularAttribute<Bicicleta, Integer> id;
	public static volatile SingularAttribute<Bicicleta, String> numSerie;

}

