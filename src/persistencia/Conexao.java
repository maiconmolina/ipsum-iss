package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
 
 //nome da unidade de persistencia definia no persistence.xml
 private static final String UNIT_NAME = "IpsumPU";
  
 private static EntityManagerFactory emf = null;
  
 private static EntityManager em = null;
  
 public EntityManager getEntityManager() {
   
  if (emf == null) {
   emf = Persistence.createEntityManagerFactory(UNIT_NAME);
  }
   
  if (em == null) {
   em = emf.createEntityManager();
  }
   
  return em;
 }
 
 
}