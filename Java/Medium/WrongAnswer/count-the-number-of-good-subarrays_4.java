class Solution {
    public long countGood(int[] nums, int k) {
        
        int n = nums.length;
        long ans = 0;
        int[] cnt = new int[n + 1];
        int sum = 0;
        cnt[0] = 1;
        for (int num : nums) {
            sum += num;
            if (sum >= k) {
                ans += cnt[sum - k];
            }
            cnt[sum]++;
        }
        return ans;
    }
}