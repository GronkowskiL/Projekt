public class Client {
    private String group;
    private int paymentDelayChance;
    private int avoidPenaltyChance;
    private int contractLossChance;

    public Client(String group, int paymentDelayChance, int avoidPenaltyChance, int contractLossChance) {
        this.group = group;
        this.paymentDelayChance = paymentDelayChance;
        this.avoidPenaltyChance = avoidPenaltyChance;
        this.contractLossChance = contractLossChance;
    }

    public String getGroup() {
        return group;
    }

    public int getPaymentDelayChance() {
        return paymentDelayChance;
    }

    public int getAvoidPenaltyChance() {
        return avoidPenaltyChance;
    }

    public int getContractLossChance() {
        return contractLossChance;
    }
}