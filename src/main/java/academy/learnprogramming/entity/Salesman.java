package academy.learnprogramming.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Salesman {

    @Id
    @GeneratedValue
    private Long id ;
    private String name ;
    private String city;
    private boolean isManager;
    private Long salary;

    public Salesman() {
    }

    public Salesman( String name, String city, boolean isManager, Long salary) {

        this.name = name;
        this.city = city;
        this.isManager = isManager;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean getIsManager() {
        return isManager;
    }

    public void setIsManager(boolean manager) {
        isManager = manager;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
