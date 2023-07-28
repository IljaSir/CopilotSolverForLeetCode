class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int n = nums.length;
        int l = 0, r = 0;
        int max = 0;
        while (r < n) {
            if (nums[r] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[l] == 0) {
                    k++;
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}