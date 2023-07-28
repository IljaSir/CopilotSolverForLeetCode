class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int i = 0;
        int j = 0;
        int res = 0;
        int n = nums.length;
        while (j < n) {
            if (nums[j] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[i] == 0) {
                    k++;
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}