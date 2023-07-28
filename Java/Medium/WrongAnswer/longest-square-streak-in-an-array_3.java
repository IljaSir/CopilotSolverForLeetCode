class Solution {
    public int longestSquareStreak(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num && map.containsKey(sqrt)) {
                dp[i] = dp[map.get(sqrt)] + 1;
            }
            map.put(num, i);
            max = Math.max(max, dp[i]);
        }
        return max >= 3 ? max : -1;
    }
}