class Solution {
    public int minKBitFlips(int[] nums, int k) {
        
        int count = 0;
        int n = nums.length;
        boolean[] flip = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flip[i] ^= flip[i - k];
            }
            if (flip[i] == true) {
                nums[i] ^= 1;
            }
            if (nums[i] == 0) {
                if (i + k > n) {
                    return -1;
                }
                count++;
                flip[i] ^= true;
            }
        }
        return count;
    }
}