class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        double totalWaitingTime = 0;
        int endTime = 0;
        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int time = customer[1];
            if (arrivalTime > endTime) {
                endTime = arrivalTime;
            }
            endTime += time;
            totalWaitingTime += endTime - arrivalTime;
        }
        return totalWaitingTime / customers.length;
    }
}