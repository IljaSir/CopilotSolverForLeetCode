class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int n = nums.length;
        if(n < 3) return false;
        int min = nums[0];
        int max = nums[1];
        boolean isIncreasing = min < max;
        for(int i = 2; i < n; i++) {
            if(nums[i] > max) {
                max = nums[i];
            } else if(nums[i] < min) {
                min = nums[i];
            } else {
                if(isIncreasing) return true;
                max = nums[i];
                isIncreasing = true;
            }
        }
        return isIncreasing;
    }
}