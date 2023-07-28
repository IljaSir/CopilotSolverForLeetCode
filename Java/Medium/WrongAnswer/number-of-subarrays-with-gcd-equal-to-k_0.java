class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        int n = nums.length;
        int[] cnt = new int[k];
        for (int i = 0; i < n; i++) {
            cnt[nums[i] % k]++;
        }
        int ans = 0;
        for (int i = 0; i <= k / 2; i++) {
            if (i == 0 || k - i == i) {
                ans += Math.max(cnt[i], 1);
            } else {
                ans += Math.max(cnt[i], cnt[k - i]);
            }
        }
        return ans;
    }
}