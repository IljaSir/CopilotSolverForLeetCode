class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        int n = customers.length;
        int start = customers[0][0];
        int end = start + customers[0][1];
        int total = end - start;
        for (int i = 1; i < n; i++) {
            int[] c = customers[i];
            start = Math.max(start, c[0]);
            end = start + c[1];
            total += end - c[0];
            start = end;
        }
        return (double) total / n;
    }
}