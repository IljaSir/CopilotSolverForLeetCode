class Solution {
    public int minimumDeletions(int[] nums) {
        
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        int left = minIndex + 1;
        int right = n - maxIndex;
        int mid = Math.min(left, right);
        return Math.min(left, right) - 1;
    }
}