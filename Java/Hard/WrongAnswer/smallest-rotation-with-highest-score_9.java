class Solution {
    public int bestRotation(int[] nums) {
        
        int n = nums.length;
        int[] bad = new int[n];
        for (int i = 0; i < n; ++i) {
            // nums[i] <= i
            bad[(i - nums[i] + 1 + n) % n]--;
            // nums[i] <= i + 1
            bad[(i - nums[i] + 1 + n) % n]--;
            // nums[i] <= i + 2
            bad[(i - nums[i] + 2 + n) % n]++;
        }
        int best = -n, ans = 0, cur = 0;
        for (int i = 0; i < n; ++i) {
            cur += bad[i];
            if (cur > best) {
                best = cur;
                ans = i;
            }
        }
        return ans;
    }
}