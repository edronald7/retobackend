package com.retobackend.repository;

import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Component;

import com.retobackend.model.CustomerStats;

@Component
public class CustomerStatsRepository extends JpaRepositoryFactory {
	
	EntityManager entityManager;

	public CustomerStatsRepository(EntityManager entityManager) {
		super(entityManager);
		this.entityManager = entityManager;
	}
	
	public CustomerStats getStatsInfo() {
		CustomerStats stats = new CustomerStats();
		
		Double avgEdad = (Double) entityManager
				.createQuery("SELECT AVG(c.edad) from Customer c").getSingleResult();		
		
		Double deviationSum = (Double) entityManager
				.createQuery("SELECT SQRT(SUM((c.edad - :avgEdad)*(c.edad - :avgEdad))) from Customer c")
				.setParameter("avgEdad", (int)avgEdad.doubleValue()).getSingleResult();

		Double sampleSizeSquaredRoot = (Double) entityManager
				.createQuery("SELECT SQRT(COUNT(c)) from Customer c")
				.getSingleResult();
		
		Double standardDeviation = (deviationSum / sampleSizeSquaredRoot);
		
		stats.setEdadPromedio(avgEdad);
		stats.setDesvEstandar(standardDeviation);
		
		//entityManager.close();
		
		return stats;
	}

}
