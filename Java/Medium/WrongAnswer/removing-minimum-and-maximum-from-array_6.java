class Solution {
    public int minimumDeletions(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
            if(nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        if(minIndex < maxIndex) {
            return minIndex + (nums.length - maxIndex - 1);
        }
        else {
            return minIndex + (nums.length - maxIndex - 2);
        }
    }
}