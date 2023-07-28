class Solution {
    public int findGCD(int[] nums) {
        
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int result = 1;
        for (int i = 2; i <= min; i++) {
            if (min % i == 0 && max % i == 0) {
                result = i;
            }
        }
        return result;
    }
}