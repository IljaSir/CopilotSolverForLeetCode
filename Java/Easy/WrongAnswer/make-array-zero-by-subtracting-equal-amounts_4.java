class Solution {
    public int minimumOperations(int[] nums) {
        
        int count = 0;
        Arrays.sort(nums);
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                count += nums[i] - nums[i - 1];
            }
        }
        return count;
    }
}