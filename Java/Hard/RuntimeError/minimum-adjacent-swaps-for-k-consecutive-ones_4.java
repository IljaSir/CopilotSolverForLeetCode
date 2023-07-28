class Solution {
    public int minMoves(int[] nums, int k) {
        
        int n = nums.length;
        int[] ones = new int[k];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                ones[j++] = i;
            }
        }
        int median = ones[k / 2];
        int res = 0;
        for (int i = 0; i < k; i++) {
            res += Math.abs(ones[i] - median) - Math.abs(i - k / 2);
        }
        return res;
    }
}