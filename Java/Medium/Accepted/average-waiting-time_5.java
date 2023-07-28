class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        double total = 0;
        int last = 0;
        for (int[] c : customers) {
            int start = Math.max(last, c[0]);
            last = start + c[1];
            total += last - c[0];
        }
        return total / customers.length;
    }
}