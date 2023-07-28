class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        int n = customers.length;
        int time = 0;
        double ans = 0;
        for (int i = 0; i < n; i++) {
            int arrive = customers[i][0];
            int cost = customers[i][1];
            if (arrive > time) {
                time = arrive;
            }
            time += cost;
            ans += time - arrive;
        }
        return ans / n;
    }
}