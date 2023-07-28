class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int n = seats.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                left[i] = 0;
            } else {
                left[i] = i > 0 ? left[i - 1] + 1 : 1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                right[i] = 0;
            } else {
                right[i] = i < n - 1 ? right[i + 1] + 1 : 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                max = Math.max(max, Math.min(left[i], right[i]));
            }
        }
        return max;
    }
}