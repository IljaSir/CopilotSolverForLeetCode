class Solution {
    public int partitionArray(int[] nums, int k) {
        
        Arrays.sort(nums);
        int res = 1;
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
            if (max - min > k) {
                res++;
                max = nums[i];
                min = nums[i];
            }
        }
        return res;
    }
}