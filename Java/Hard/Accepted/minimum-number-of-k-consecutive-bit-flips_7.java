class Solution {
    public int minKBitFlips(int[] nums, int k) {
        
        int n = nums.length;
        int[] flips = new int[n];
        int flip = 0;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= k) flip ^= flips[i - k];
            if (flip == nums[i]) {
                if (i + k > n) return -1;
                ++res;
                flip ^= 1;
                flips[i] = 1;
            }
        }
        return res;
    }
}