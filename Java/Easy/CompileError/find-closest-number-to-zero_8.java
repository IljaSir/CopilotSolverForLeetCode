class Solution {
    public int findClosestNumber(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                nums[i] = -nums[i];
            }
            if(nums[i] < min) {
                min = nums[i];
                minIndex = i;
            } else if(nums[i] == min) {
                if(nums[i] > nums[minIndex]) {
                    minIndex = i;
                }
            }
        }
        return nums[minIndex];
    }
}
    }
}