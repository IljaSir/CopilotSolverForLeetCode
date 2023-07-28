class Solution {
    public int sumOfBeauties(int[] nums) {
        
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[nums.length-1] = nums[nums.length-1];
        for(int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i-1], nums[i]);
        }
        for(int i = nums.length-2; i >= 0; i--) {
            max[i] = Math.max(max[i+1], nums[i]);
        }
        int sum = 0;
        for(int i = 1; i < nums.length-1; i++) {
            if(nums[i] > min[i-1] && nums[i] < max[i+1]) {
                sum += 2;
            } else if(nums[i-1] < nums[i] && nums[i] < nums[i+1]) {
                sum += 1;
            }
        }
        return sum;
    }
}