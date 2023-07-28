class Solution {
    public int partitionArray(int[] nums, int k) {
        
        Arrays.sort(nums);
        int min = 0;
        int max = 0;
        int count = 0;
        while (max < nums.length) {
            if (nums[max] - nums[min] > k) {
                min = max;
            }
            max++;
            if (min == max) {
                count++;
            }
        }
        return count;
    }
}