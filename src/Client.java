public class Client {
    private String group;
    private int paymentDelayChance;
    private int avoidPenaltyChance;
    private int contractLossChance;

    public Client(int group) {


        if( group == 1) {
            this.group = "wyluzowany";

            this.paymentDelayChance = 30;
            this.avoidPenaltyChance = 20;
            this.contractLossChance = 0;
        } else if( group == 2) {
            this.group = "wymagajacy";

            this.paymentDelayChance = 30;
            this.avoidPenaltyChance = 20;
            this.contractLossChance = 0;
        } else if( group == 3){
            this.group = "skrwl";

            this.paymentDelayChance = 30;
            this.avoidPenaltyChance = 20;
            this.contractLossChance = 0;
        }

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