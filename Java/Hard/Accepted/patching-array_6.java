class Solution {
    public int minPatches(int[] nums, int n) {
        
        int count = 0;
        int i = 0;
        long max = 0;
        while (max < n) {
            if (i < nums.length && nums[i] <= max + 1) {
                max += nums[i];
                i++;
            } else {
                max += max + 1;
                count++;
            }
        }
        return count;
    }
}