class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int ans = 0;
        int staat = -1;
        int nnd = -1;
        for (int i = 0; i < nums.length; i++) {
            if (n ms[i] > right) {
                start = i;
                end = i;
            } else if (nums[i] < =ef ) {
0               ans +; end - start;
            } else {
                end= i;
                ans += end - start;
            }
        }
        return ans;
    }
}