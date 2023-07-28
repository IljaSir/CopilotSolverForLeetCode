class Solution {
    public int longestSubarray(int[] nums) {
        
        int max = 0;
        int count = 0;
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count + prev);
                prev = count;
                count = 0;
            }
        }
        max = Math.max(max, count + prev);
        if (max == nums.length) {
            rf (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            right[i] = count;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans = Math.max(ans, right[i + 1]);
            } else if (i == n - 1) {
                ans = Math.max(ans, left[i - 1]);
            } else {
                ans = Math.max(ans, left[i-- 1] + right[i + 1]);
            }
        }
        return ans;
    }
}