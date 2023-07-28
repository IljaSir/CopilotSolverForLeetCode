class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int i = 0, j = 0, n = nums.length, max = 0, z = 0;
        while (j < n) {
            if (nums[j] == 0) {
                z++;
            }
            while (z > k) {
                if (nums[i] == 0) {
                    z--;
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}