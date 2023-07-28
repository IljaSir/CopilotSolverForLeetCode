class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.sort(nums);
        int max = 0;
        int maxIdx = -1;
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if(dp[i] > max) {
                max = dp[i];
                maxIdx = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while(maxIdx != -1) {
            res.add(nums[maxIdx]);
            maxIdx = prev[maxIdx];
        }
        return res;
    }
}