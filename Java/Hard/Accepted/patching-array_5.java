class Solution {
    public int minPatches(int[] nums, int n) {
        
        int i = 0;
        int patch = 0;
        long miss = 1;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                patch++;
            }
        }
        return patch;
    }
}