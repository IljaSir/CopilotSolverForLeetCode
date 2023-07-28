class Solution {
    public int partitionDisjoint(int[] nums) {
        
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        leftMax[0] = nums[0];
        rightMin[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
            rightMin[n - i - 1] = Math.min(rightMin[n - i], nums[n - i - 1]);
        }
        for (int i = 1; i < n; i++) {
            if (leftMax[i - 1] <= rightMin[i]) {
                return i;
            }
        }
        return -1;
    }
}