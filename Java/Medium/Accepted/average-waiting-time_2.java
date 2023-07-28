class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        double sum = 0;
        int curTime = 0;
        for(int[] customer : customers) {
            curTime = Math.max(curTime, customer[0]) + customer[1];
            sum += curTime - customer[0];
        }
        return sum / customers.length;
    }
}