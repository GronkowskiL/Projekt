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



    private int clientType;

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

    public enum Technologies{
        front_end, backend, database, mobile, wordpress, prestashop
    }



    public Project(int id, Complexity complexity, int price, int daysToComplete, int daysToPay, int clientType) {
        this.id = id;
        this.name = project_names[id];
        this.complexity = complexity;
        setTechnologies();
        this.price = price;
        this.daysToComplete = daysToComplete;
        this.daysToPay = daysToPay;
        this.clientType = clientType;
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

    public int getClientType() {
        return clientType;
    }

    public String getName() {
        return "Project " + id;
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
                ", clientType=" + clientType +
                '}';
    }
}