class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        int n = nums.length;
        long ans = 0;
        long sum = 0;
        int[] cnt = new int[100001];
        int distinct = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (cnt[nums[i]]++ == 0) {
                distinct++;
            }
            if (i >= k) {
                if (--cnt[nums[i - k]] == 0) {
                    distinct--;
                }
                sum -= nums[i - k];
            }
            if (distinct == k) {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}