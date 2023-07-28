class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int max = 0;
        int prev = -1;
        int n = seats.length;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                if (prev == -1) {
                    max = i;
                } else {
                    max = Math.max(max, (i - prev) / 2);
                }
                prev = i;
            }
        }
        if (seats[n - 1] == 0) {
            max = Math.max(max, n - 1 - prev);
        }
        return max;
    }
}