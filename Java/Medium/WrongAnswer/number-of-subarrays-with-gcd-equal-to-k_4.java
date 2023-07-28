class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        int n = nums.length;
        int[] cnt = new int[k];
        for (int num : nums) {
            cnt[num % k]++;
        }
        int ans = 0;
        for (int i = 1; i <= k / 2; i++) {
            ans += Math.max(cnt[i], cnt[k - i]);
        }
        ans += Math.min(cnt[0], 1);
        return ans;
    }
}