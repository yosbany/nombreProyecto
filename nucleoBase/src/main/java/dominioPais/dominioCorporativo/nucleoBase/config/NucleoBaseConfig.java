package dominioPais.dominioCorporativo.nucleoBase.config;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author Yosbany Tejas
 *
 */
@ComponentScan(basePackages = { "dominioPais.dominioCorporativo.nucleoBase" })
@Configuration(value = "nucleo-base-config")
@EnableTransactionManagement
public class NucleoBaseConfig {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "name", mappedName = "java:datasource")
	private DataSource dataSource;

	private LocalSessionFactoryBean fabricaSesiones;
	
	private PropertiesFactoryBean propiedadesHibernate;

	
	@PostConstruct
	public void init() {
		log.info("");
	}

	/**
	 * Retorna el gestor de transacciones de Hibernate
	 * 
	 * @author fabian.lobo
	 * @since 1.0
	 */
	@Bean(name = "transaction-manager")
	@DependsOn(value = { "session-factory" })
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(fabricaSesiones.getObject());
		return manager;
	}

	
	@Bean(name = "session-factory")
	@DependsOn(value = { "hibernate-properties" })
	@Lazy
	public LocalSessionFactoryBean getSessionFactory() {
		fabricaSesiones = new LocalSessionFactoryBean();
		fabricaSesiones.setDataSource(dataSource);
		fabricaSesiones.setPackagesToScan("uy.gub.msp.seven.rcorppd.business.entities");
		try {
			fabricaSesiones.setHibernateProperties(propiedadesHibernate.getObject());
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return fabricaSesiones;
	}

	
	@Bean(name = "hibernate-properties")
	public PropertiesFactoryBean getHibernateProperties() {
		propiedadesHibernate = new PropertiesFactoryBean();
		propiedadesHibernate.setLocations(new ClassPathResource("hibernate.properties"), new ClassPathResource("rcorppd-hibernate.properties"));

		return propiedadesHibernate;
	}

}
