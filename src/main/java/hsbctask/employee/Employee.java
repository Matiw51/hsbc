package hsbctask.employee;

public class Employee {
    private Long id;
    private String name;
    private String surname;
    private Integer grade;
    private Integer salary;

    public Employee() {
    }

    public Employee(Long id, String name, String surname, Integer grade, Integer salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
