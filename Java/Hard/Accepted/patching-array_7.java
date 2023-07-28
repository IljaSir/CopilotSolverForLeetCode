class Solution {
    public int minPatches(int[] nums, int n) {
        
        int patches = 0;
        long maxReachable = 0;
        int i = 0;
        while (maxReachable < n) {
            if (i < nums.length && nums[i] <= maxReachable + 1) {
                maxReachable += nums[i];
                i++;
            } else {
                maxReachable += maxReachable + 1;
                patches++;
            }
        }
        return patches;
    }
}