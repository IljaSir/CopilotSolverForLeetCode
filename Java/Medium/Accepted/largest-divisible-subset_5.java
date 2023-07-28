class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        int max = 0, maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        while (maxIndex != -1) {
            res.add(nums[maxIndex]);
            maxIndex = pre[maxIndex];
        }
        return res;
    }
}