class Solution {
    public int partitionDisjoint(int[] nums) {
        
        int n = nums.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];
        int m = nums[0];
        for (int i = 0; i < n; ++i) {
            m = Math.max(m, nums[i]);
            maxLeft[i] = m;
        }
        m = nums[n-1];
        for (int i = n - 1; i >= 0; --i) {
            m = Math.min(m, nums[i]);
            minRight[i] = m;
        }
        for (int i = 1; i < n; ++i) {
            if (maxLeft[i-1] <= minRight[i])
                return i;
        }
        return -1;
    }
}