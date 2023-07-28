class Solution {
    public int sumSubseqWidths(int[] nums) {
        
        int mod = 1000000007;
        Arrays.sort(nums);
        long[] pow2 = new long[nums.length];
        pow2[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pow2[i] = pow2[i - 1] * 2 % mod;
        }
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = (res + (pow2[i] - pow2[nums.length - i - 1]) * nums[i]) % mod;
        }
        return (int)res;
    }
}