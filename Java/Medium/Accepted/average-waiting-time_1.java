class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        long time = 0;
        long total = 0;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i][0] > time) {
                time = customers[i][0] + customers[i][1];
            } else {
                time += customers[i][1];
            }
            total += time - customers[i][0];
        }
        return (double) total / customers.length;
    }
}