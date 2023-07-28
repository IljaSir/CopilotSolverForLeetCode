class Solution {
    public int destroyTargets(int[] nums, int space) {
        
        Arrays.sort(nums);
        int max = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int count = 1;
            int start = nums[i];
            int end = nums[i] + space - 1;
            for(int j = i + 1; j < n; j++) {
                if(nums[j] > end) {
                    count++;
                    end = nums[j] + space - 1;
                }
            }
            max = Math.max(max, count
        int res = 1;
        for (int i = n - 1; i >= 0; --i) {
            int j = i;
            while (j > 0 && nums[i] - nums[j - 1] <= space) {
                --j;
            }
            dp[i] = 1 + (j == 0 ? 0 : dp[j - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}