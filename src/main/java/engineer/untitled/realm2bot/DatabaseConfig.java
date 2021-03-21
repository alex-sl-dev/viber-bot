package engineer.untitled.realm2bot;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {
	@Bean
	public DataSource dataSource() {
		// override app.prop
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://database-2.cbqhfgkldg4a.eu-west-1.rds.amazonaws.com:5432/postgres?set=UTF-8");
		dataSource.setUsername("postgres");
		dataSource.setPassword("orfgo58YTMABVgr9TuDa");

		return dataSource;
	}
}
