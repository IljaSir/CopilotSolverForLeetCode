class Solution {
    public int minKBitFlips(int[] nums, int k) {
        
        int n = nums.length;
        int[] flip = new int[n + 1];
        int res = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur ^= flip[i];
            if (cur == nums[i]) {
                if (i + k > n) {
                    return -1;
                }
                res++;
                cur ^= 1;
                flip[i + k] ^= 1;
            }
        }
        return res;
    }
}