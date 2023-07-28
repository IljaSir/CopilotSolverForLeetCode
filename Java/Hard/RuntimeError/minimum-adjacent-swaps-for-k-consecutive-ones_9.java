class Solution {
    public int minMoves(int[] nums, int k) {
        
        int n = nums.length;
        int[] ones = new int[k];
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] == 1) {
                ones[i++] = j;
            }
        }
        int median = ones[k / 2];
        int res = 0;
        for (int one : ones) {
            res += Math.abs(one - median);
        }
        return res;
    }
}