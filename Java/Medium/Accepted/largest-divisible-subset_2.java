class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        Arrays.sort(nums);
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (maxIndex != -1) {
            ans.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        return ans;
    }
}