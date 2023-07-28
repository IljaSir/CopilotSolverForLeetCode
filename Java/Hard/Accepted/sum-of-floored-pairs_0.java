class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        int[] count = new int[max + 1];
        for (int n : nums) {
            count[n]++;
        }
        int[] sum = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            sum[i] = sum[i - 1] + count[i];
        }
        int mod = 1_000_000_007;
        long res = 0;
        for (int i = 1; i <= max; i++) {
            if (count[i] == 0) {
                continue;
            }
            for (int j = 1; j <= max / i; j++) {
                int k = Math.min(max, j * i + i - 1);
                res += (long) count[i] * (sum[k] - sum[j * i - 1]) * j;
            }
        }
        return (int) (res % mod);
    }
}