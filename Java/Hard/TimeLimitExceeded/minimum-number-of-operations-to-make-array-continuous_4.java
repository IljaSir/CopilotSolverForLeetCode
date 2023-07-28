class Solution {
    public int minOperations(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[n - 1];
        if (max - min + 1 == n) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int maxCount = 0;
        while (j < n) {
            while (j < n && nums[j] <= min + j) {
                j++;
            }
            maxCount = Math.max(maxCount, j - i);
            i++;
        }
        return n - maxCount;
    }
}