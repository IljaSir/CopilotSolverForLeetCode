class Solution {
    public int sumSubseqWidths(int[] nums) {
        
        int MOD = 1_000_000_007;
        int N = nums.length;
        Arrays.sort(nums);
        long[] pow2 = new long[N];
        pow2[0] = 1;
        for (int i = 1; i < N; ++i)
            pow2[i] = pow2[i-1] * 2 % MOD;

        long ans = 0;
        for (int i = 0; i < N; ++i)
            ans = (ans + nums[i] * (pow2[i] - pow2[N-1-i])) % MOD;
        return (int) ans;
    }
}