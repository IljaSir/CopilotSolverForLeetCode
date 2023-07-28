class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        long ans = 0;
        for (int i = 0; i < k; ++i) {
            ans += nums[i];
        }
        long cur = ans;
        int[] cnt = new int[100001];
        for (int i = 0; i < k; ++i) {
            ++cnt[nums[i]];
        }
        for (int i = k; i < nums.length; ++i) {
            cur += nums[i];
            --cnt[nums[i - k]];
            while (cnt[nums[i]] > 0) {
                --cnt[nums[i - k]];
                cur -= nums[i - k];
                ++i;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}