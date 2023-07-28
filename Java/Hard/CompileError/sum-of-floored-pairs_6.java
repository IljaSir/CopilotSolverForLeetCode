class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        
        int max = 0;
        for (int n: nums) {
            max = Math.max(n, max);
        }
        int[] count = new int[max+1];
        for (int n: nums) {
            count[n]++;
        }
        for (int i = 1; i <= max; i++) {
            count[i] += count[i-1];
        }
        int mod = 1000000007;
        int sum = 0;
        for (int i = 1; i <= max; i++) {
            int c = count[i];
            for (int j = 1; j*i <= max; j++) {
                int k = Math.min(j*i + i - 1, max);
                int d = count[k] - c;
                sum = (sum + (long)d * j) % mod;
            }
        }
        return sum;
    }
}