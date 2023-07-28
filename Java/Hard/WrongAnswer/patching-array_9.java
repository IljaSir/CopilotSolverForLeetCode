class Solution {
    public int minPatches(int[] nums, int n) {
        
        int patches = 0;
        long max = 0;
        for (int i = 0; max < n; i++) {
            if (i < nums.length && nums[i] <= max + 1) {
                max += nums[i];
            } else {
                max += max + 1;
                patches++;
            }
        }
        return patches;
    }
}