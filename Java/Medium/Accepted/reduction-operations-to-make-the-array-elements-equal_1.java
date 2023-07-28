class Solution {
    public int reductionOperations(int[] nums) {
        
        Arrays.sort(nums);
        int count = 0;
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i] != nums[i - 1]) {
                count += nums.length - i;
            }
            i--;
        }
        return count;
    }
}