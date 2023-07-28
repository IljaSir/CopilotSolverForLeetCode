class Solution {
    public int partitionArray(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < n) {
            while (j < n && nums[j] - nums[i] <= k) {
                j++;
            }
            i = j;
            count++;
        }
        return count;
    }
}