class Solution {
    public int countTriplets(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[1<<16];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[nums[i] & nums[j]]++;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1<<16; j++) {
                if ((nums[i] & j) == 0) {
                    res += count[j];
                }
            }
        }
        return res;
    }
}