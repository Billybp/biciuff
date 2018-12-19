package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Estacao.class)
public abstract class Estacao_ {

	public static volatile SingularAttribute<Estacao, String> endereco;
	public static volatile ListAttribute<Estacao, Aluguel> aluguelList;
	public static volatile SingularAttribute<Estacao, String> nome;
	public static volatile SingularAttribute<Estacao, String> tel;
	public static volatile SingularAttribute<Estacao, Integer> id;
	public static volatile ListAttribute<Estacao, Aluguel> aluguelList1;

}

