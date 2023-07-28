class Solution {
    public int thirdMax(int[] nums) {
        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2 && nums[i] < max1) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3 && nums[i] < max2) {
                max3 = nums[i];
            }
            if (nums[i] == Integer.MIN_VALUE) {
                flag = true;
            }
        }
        if (max3 == Integer.MIN_VALUE && flag == true) {
            return max1;
        } else if (max3 == Integer.MIN_VALUE) {
            return max2;
        } else {
            return max3;
        }
    }
}