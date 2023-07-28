class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        int n = capacity.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int c = capacity[i] - rocks[i];
            if (c <= additionalRocks) {
                additionalRocks -= c;
                left[i] = 0;
            } else {
                left[i] = c - additionalRocks;
                additionalRocks = 0;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            int c = capacity[i] - rocks[i];
            if (c <= additionalRocks) {
                additionalRocks -= c;
                right[i] = 0;
            } else {
                right[i] = c - additionalRocks;
                additionalRocks = 0;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] == 0 && right[i] == 0) {
                ans++;
            }
        }
        return ans;
    }
}