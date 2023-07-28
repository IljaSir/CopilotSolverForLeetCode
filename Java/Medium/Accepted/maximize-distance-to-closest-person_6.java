class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int n = seats.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) prev = i;
            if (prev == -1) left[i] = n;
            else left[i] = i - prev;
        }
        prev = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) prev = i;
            if (prev == -1) right[i] = n;
            else right[i] = prev - i;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                ans = Math.max(ans, Math.min(left[i], right[i]));
            }
        }
        return ans;
    }
}