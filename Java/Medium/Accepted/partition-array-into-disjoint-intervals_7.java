class Solution {
    public int partitionDisjoint(int[] nums) {
        
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = nums[0];
        right[len-1] = nums[len-1];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i-1], nums[i]);
            right[len-1-i] = Math.min(right[len-i], nums[len-1-i]);
        }
        for (int i = 1; i < len; i++) {
            if (left[i-1] <= right[i]) {
                return i;
            }
        }
        return 1;
    }
}