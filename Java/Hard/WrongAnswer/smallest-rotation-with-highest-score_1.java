class Solution {
    public int bestRotation(int[] nums) {
        
        int n = nums.length;
        int[] change = new int[n];
        for (int i = 0; i < n; i++) {
            change[(i - nums[i] + 1 + n) % n]--;
        }
        int best = -n;
        int ans = 0, now = 0;
        for (int i = 0; i < n; i++) {
            now += change[i];
            if (now > best) {
                best = now;
                ans = i;
            }
        }
        return ans;
    }
}