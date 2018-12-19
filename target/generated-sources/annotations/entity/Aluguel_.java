package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Aluguel.class)
public abstract class Aluguel_ {

	public static volatile SingularAttribute<Aluguel, Estacao> estOri;
	public static volatile SingularAttribute<Aluguel, Bicicleta> biciId;
	public static volatile SingularAttribute<Aluguel, Integer> id;
	public static volatile SingularAttribute<Aluguel, Usuario> userID;
	public static volatile SingularAttribute<Aluguel, Estacao> estDest;
	public static volatile SingularAttribute<Aluguel, Date> horaRet;

}

