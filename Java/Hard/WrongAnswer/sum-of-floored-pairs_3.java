class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        
        int mod = 1000000007;
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }
        int[] count = new int[max + 1];
        for (int x : nums) {
            count[x]++;
        }
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        long res = 0;
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                res += (long) (count[Math.min(max, j + i - 1)] - count[j - 1]) * (j / i);
            }
        }
        return (int) (res % mod);
    }
}