class Solution {
    public int minimumDeletions(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(left[i - 1], nums[i]);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], nums[i]);
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = n - i - 1;
            int cur = 0;
            if (l > 0) {
                cur += l - 1;
            }
            if (r > 0) {
                cur += r - 1;
            }
            if (i > 0 && i < n - 1 && left[i - 1] < right[i + 1]) {
                cur++;
            }
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}