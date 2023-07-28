class Solution {
    public int minMoves(int[] nums, int k) {
        
        int[] ones = new int[k];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ones[index++] = i;
            }
        }
        int median = k / 2;
        int ans = 0;
        for (int i = 0; i < k / 2; i++) {
            ans += ones[median + i] - ones[i] - (median - i);
        }
        return ans;
    }
}