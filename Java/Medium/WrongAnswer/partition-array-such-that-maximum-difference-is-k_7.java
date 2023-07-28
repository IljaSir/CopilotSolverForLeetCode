class Solution {
    public int partitionArray(int[] nums, int k) {
        
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int max = nums[n - 1];
        int min = nums[0];
        int diff = max - min;
        int count = 1;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[j] - nums[i] <= k) {
                j++;
            }
            count++;
            i = j;
        }
        return count;
    }
}