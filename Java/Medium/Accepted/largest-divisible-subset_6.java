class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        List<Integer> res = new ArrayList<Integer>();
        int n = nums.length;
        if (n == 0) return res;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        while (maxIndex != -1) {
            res.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        return res;
    }
}