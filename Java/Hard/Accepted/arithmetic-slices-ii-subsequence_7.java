class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int n = nums.length;
        int result = 0;
        Map<Integer, Integer>[] dp = new Map[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }
                int d = (int) diff;
                int c1 = dp[i].getOrDefault(d, 0);
                int c2 = dp[j].getOrDefault(d, 0);
                result += c2;
                dp[i].put(d, c1 + c2 + 1);
            }
        }
        return result;
    }
}