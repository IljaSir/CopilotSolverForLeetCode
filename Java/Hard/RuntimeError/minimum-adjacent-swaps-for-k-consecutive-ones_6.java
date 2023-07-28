class Solution {
    public int minMoves(int[] nums, int k) {
        
        int n = nums.length;
        int[] pos = new int[k];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                pos[j++] = i;
            }
        }
        int median = pos[k / 2];
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += Math.abs(pos[i] - median) - Math.abs(i - k / 2);
        }
        return ans;
    }
}