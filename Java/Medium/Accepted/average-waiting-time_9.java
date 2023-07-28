class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        double avgWaitingTime = 0;
        int chefTime = 0;
        for(int i=0;i<customers.length;i++){
            int arrivalTime = customers[i][0];
            int preparationTime = customers[i][1];
            if(arrivalTime>chefTime){
                chefTime = arrivalTime;
            }
            chefTime += preparationTime;
            avgWaitingTime += chefTime - arrivalTime;
        }
        return avgWaitingTime/customers.length;
    }
}