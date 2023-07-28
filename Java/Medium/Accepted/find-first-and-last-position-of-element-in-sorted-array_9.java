class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] res = new int[]{-1, -1};
        int i = 0;
        int j = nums.length - 1;
        while (i < nums.length && nums[i] != target) {
            i++;
        }
        while (j >= 0 && nums[j] != target) {
            j--;
        }
        if (i < nums.length && j >= 0) {
            res[0] = i;
            res[1] = j;
        }
        return res;
    }
}