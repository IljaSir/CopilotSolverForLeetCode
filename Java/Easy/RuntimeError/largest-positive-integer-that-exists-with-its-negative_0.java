class Solution {
    public int findMaxK(int[] nums) {
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                max = Math.max(max, nums[i]);
            }
        }
        boolean[] exist = new boolean[max + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                exist[nums[i]] = true;
            }
        }
        for (int i = max; i >= 1; i--) {
            if (exist[i] && exist[-i]) {
                return i;
            }
        }
        return -1;
    }
}