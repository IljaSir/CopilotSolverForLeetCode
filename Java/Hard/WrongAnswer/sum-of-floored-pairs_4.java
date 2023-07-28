class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        
        int max = 0;
        for (int n : nums) max = Math.max(max, n);
        int[] cnt = new int[max + 1];
        for (int n : nums) cnt[n]++;
        for (int i = 1; i <= max; i++) cnt[i] += cnt[i - 1];
        long res = 0;
        for (int i = 1; i <= max; i++) {
            long sum = 0;
            for (int j = 1; j * i <= max; j++) {
                sum += (long) (cnt[Math.min(max, j * i + i - 1)] - cnt[j * i - 1]) * j;
            }
            res = (res + sum * cnt[i]) % 1000000007;
        }
        return (int) res;
    }
}