class Solution {
    public int partitionDisjoint(int[] nums) {
        
        int n = nums.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            maxLeft[i] = max;
        }
        int min = nums[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minRight[i] = min;
        }
        for (int i = 1; i < n; i++) {
            if (maxLeft[i - 1] <= minRight[i]) {
                return i;
            }
        }
        return 0;
    }
}