public class Subcontractor {
    private String qualifications;
    private int cost;
    private int risk;

    public Subcontractor(String qualifications, int cost, int risk) {
        this.qualifications = qualifications;
        this.cost = cost;
        this.risk = risk;
    }

    public String getQualifications() {
        return qualifications;
    }

    public int getCost() {
        return cost;
    }

    public int getRisk() {
        return risk;
    }
}