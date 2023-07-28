class Solution {
    public long minimalKSum(int[] nums, int k) {
        
        Arrays.sort(nums);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                k++;
            } else {
                sum += nums[i];
            }
        }
        return sum + k;
    }
}