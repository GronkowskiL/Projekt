public class Employee {
    private String name;
    private int age;
    private String designation;
    private double salary;

    private String qualification;


    public Employee(String name, int age, String designation, String qualification, double salary) {
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.qualification = qualification;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public String getQualification() {
        return qualification;
    }
    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                '}';
    }
}
