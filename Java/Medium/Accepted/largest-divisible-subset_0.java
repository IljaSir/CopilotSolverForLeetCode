class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] pre = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(pre, -1);
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (maxIndex != -1) {
            ans.add(nums[maxIndex]);
            maxIndex = pre[maxIndex];
        }
        return ans;
    }
}