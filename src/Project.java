import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Project {
    private int id;
    private String name;
    private Map<Technologies, Integer> technologies = new HashMap<>();
    private Complexity complexity;
    private int price;
    private int daysToComplete;
    private int daysToPay;

    private Client client;


    private ProjectStatus status;




    private static String[] project_names = new String[]{
            "Panda 1",
            "Dog 1",
            "Cyberpunk 1",
            "Panda 2",
            "Dog 2",
            "Cyberpunk 2",
            "Panda 3",
            "Dog 3",
            "Cyberpunk 3",
            "Panda 4",
            "Dog 4",
            "Cyberpunk 4",
            "Panda 5"
    };

    public enum Complexity{
        easy, medium, difficult
    }

    public enum ProjectStatus{
        waiting_for_acceptance, accepted, testing, completed, abandoned, failed
    }

    public enum Technologies{
        front_end, backend, database, mobile, wordpress, prestashop
    }



    public Project(int id, Complexity complexity, int price, int daysToComplete, int daysToPay, Client client) {
        this.id = id;
        this.name = project_names[id];
        this.complexity = complexity;
        setTechnologies();
        this.price = price;
        this.daysToComplete = daysToComplete;
        this.daysToPay = daysToPay;
        this.client = client;
        this.status = ProjectStatus.waiting_for_acceptance;
    }

    public int getId() {
        return id;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public int getPrice() {
        return price;
    }

    public int getDaysToComplete() {
        return daysToComplete;
    }
    public Client getClient() {
        return client;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setTechnologies(){
        Technologies[] technologies = Technologies.values();
        Random random = new Random();
        int temp = random.nextInt(6);

        if( this.complexity.equals(Complexity.easy)){
            this.technologies.put(technologies[temp], random.nextInt(2)+2);
        } else if(this.complexity.equals(Complexity.medium)){
            while(this.technologies.size() < 2){
                temp = random.nextInt(6);
                this.technologies.putIfAbsent(technologies[temp], random.nextInt(2)+5);
            }
        } else {
            while(this.technologies.size() < 3){
                temp = random.nextInt(6);
                this.technologies.putIfAbsent(technologies[temp], random.nextInt(2)+10);
            }
        }
    }

    public int getDaysToPay() {
        return daysToPay;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", technologies=" + technologies +
                ", complexity=" + complexity +
                ", price=" + price +
                ", daysToComplete=" + daysToComplete +
                ", daysToPay=" + daysToPay +
                '}';
    }
}