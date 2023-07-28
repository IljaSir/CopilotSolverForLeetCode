class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        double totalWaitingTime = 0;
        int time = 0;
        for(int[] customer : customers){
            time = Math.max(time, customer[0]);
            time += customer[1];
            totalWaitingTime += time - customer[0];
        }
        return totalWaitingTime / customers.length;
    }
}