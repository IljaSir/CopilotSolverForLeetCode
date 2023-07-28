class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        int n = customers.length;
        double ans = 0;
        int t = 0;
        int i = 0;
        while (i < n) {
            int a = customers[i][0];
            int b = customers[i][1];
            if (a > t) {
                ans += a - t;
                t = a + b;
            } else {
                ans += b;
                t += b;
            }
            i++;
        }
        return ans / n;
    }
}