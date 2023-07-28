class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] cnt = new int[max + 1];
        for (int num : nums) {
            cnt[num]++;
        }
        int[] dp = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                dp[i] += cnt[j];
            }
        }
        int res = 0;
        for (int i = 1; i <= max; i++) {
            if (dp[i] > 0) {
                int j = i;
                while (j <= max) {
                    if (dp[j] > 0 && gcd(i, j) == i) {
                        res++;
                        break;
                    }
                    j += i;
                }
            }
        }
        return res;
    }
}