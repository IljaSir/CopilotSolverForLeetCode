class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        int n = customers.length;
        double waitingTime = 0;
        int currentTime = 0;
        for (int i = 0; i < n; i++) {
            if (currentTime < customers[i][0]) {
                currentTime = customers[i][0];
            }
            waitingTime += currentTime - customers[i][0] + customers[i][1];
            currentTime += customers[i][1];
        }
        return waitingTime / n;
    }
}