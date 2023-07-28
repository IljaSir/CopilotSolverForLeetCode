class Solution {
    public int sumSubseqWidths(int[] nums) {
        
        Arrays.sort(nums);
        long[] pows = new long[nums.length];
        long mod = (long) 1e9 + 7;
        pows[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pows[i] = (pows[i - 1] * 2) % mod;
        }
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = (ans + (pows[i] - pows[nums.length - i - 1]) * nums[i]) % mod;
        }
        return (int) ans;
    }
}