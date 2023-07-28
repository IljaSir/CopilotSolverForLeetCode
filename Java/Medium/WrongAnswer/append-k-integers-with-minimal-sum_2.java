class Solution {
    public long minimalKSum(int[] nums, int k) {
        
        long sum = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                k++;
            } else {
                sum += nums[i];
            }
        }
        return sum + k;
    }
}