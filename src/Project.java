public class Project {
    private int id;
    private int complexity;
    private int price;
    private int daysToComplete;
    private int daysToPay;
    private int clientType;

    public Project(int id, int complexity, int price, int daysToComplete, int daysToPay, int clientType) {
        this.id = id;
        this.complexity = complexity;
        this.price = price;
        this.daysToComplete = daysToComplete;
        this.daysToPay = daysToPay;
        this.clientType = clientType;
    }

    public int getId() {
        return id;
    }

    public int getComplexity() {
        return complexity;
    }

    public int getPrice() {
        return price;
    }

    public int getDaysToComplete() {
        return daysToComplete;
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
                ", complexity=" + complexity +
                ", price=" + price +
                ", daysToComplete=" + daysToComplete +
                ", daysToPay=" + daysToPay +
                ", clientType=" + clientType +
                '}';
    }
}
