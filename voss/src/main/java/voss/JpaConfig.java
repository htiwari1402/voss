package voss;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class JpaConfig {
       
       @Bean
          public DataSource dataSource(){
             DriverManagerDataSource dataSource = new DriverManagerDataSource();
             dataSource.setDriverClassName("com.mysql.jdbc.Driver");
             dataSource.setUrl("jdbc:mysql://localhost:3306/voss");
             dataSource.setUsername( "root" );
             dataSource.setPassword( "" );
             return dataSource;
          }
       
       @Bean   
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws  SQLException {
 
               HibernateJpaVendorAdapter hibernateJpa = new HibernateJpaVendorAdapter();
               hibernateJpa.setDatabasePlatform("org.hibernate.dialect.MySQLInnoDBDialect");
               hibernateJpa.setShowSql(false);
               LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
               emf.setDataSource(dataSource());
               emf.setPackagesToScan("voss");
               emf.setJpaVendorAdapter(hibernateJpa);
               //emf.setJpaPropertyMap(Collections.singletonMap("javax.persistence.validation.mode", "none"));
               return emf;
           }
       @Bean
       public JpaTransactionManager transactionManager(EntityManagerFactory emf) throws ClassNotFoundException, SQLException {
               JpaTransactionManager txnMgr = new JpaTransactionManager();
               txnMgr.setEntityManagerFactory(entityManagerFactory().getObject());
               return txnMgr;
           }
}
