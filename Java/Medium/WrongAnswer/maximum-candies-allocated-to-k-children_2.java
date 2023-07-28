class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        int n = candies.length;
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            r += candies[i];
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            if (check(candies, k, m)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l - 1;
    }
    
    private boolean check(int[] candies, long k, int m) {
        int n = candies.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (candies[i] > m) {
                count += (candies[i] - m);
            }
        }
        return count >= k;
    }
}