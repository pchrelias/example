package academy.learnprogramming.service;


import academy.learnprogramming.entity.Salesman;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Transactional
public class SalesmanService {

    @PersistenceContext
    EntityManager entityManager;

    public Salesman createSM(Salesman sm){
        entityManager.persist(sm);
        return sm;
    }

    public Salesman updateSm(Salesman sm){
        entityManager.merge(sm);
        return  sm;
    }

    public Salesman findSalsmanById(int id){
        return entityManager.find(Salesman.class,id);
    }

    public  String deleteSalemanById(int id){
        Salesman sm = entityManager.find(Salesman.class,id);
        entityManager.remove(sm);
        return ("Salemsan succesfully deleted");
    }

    public List<Salesman> listOfManagers(){
        return entityManager.createQuery("SELECT sm FROM Salesman sm WHERE sm.isManager='true'",Salesman.class).getResultList();
    }

    public List<Salesman> salesmenList (){
        return  entityManager.createQuery("SELECT sm FROM Salesman sm",Salesman.class).getResultList();
    }


    public String autoCreateSalesman(){
        Salesman sm = new Salesman("Salesman","Athens",true, (long) 41234);
        Random random = new Random();
            entityManager.persist(sm);
            sm.setName(sm.getName()+(random.nextInt(100)));
            sm.setIsManager(random.nextBoolean());
            sm.setSalary((long)random.nextInt(1000));

        return "Salesman created";
    }

}
