class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        int n = candies.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candies[i];
        }
        int max = sum / n;
        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[Math.min(max, candies[i])]++;
        }
        for (int i = max - 1; i >= 1; i--) {
            count[i] += count[i + 1];
        }
        long ans = 0;
        for (int i = max; i >= 1; i--) {
            long t = Math.min(k, count[i]);
            ans += t * i;
            k -= t;
        }
        return (int) ans;
    }
}