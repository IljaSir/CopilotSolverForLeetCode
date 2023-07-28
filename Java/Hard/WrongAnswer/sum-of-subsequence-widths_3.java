class Solution {
    public int sumSubseqWidths(int[] nums) {
        
        int MOD = 1_000_000_007;
        Arrays.sort(nums);
        int n = nums.length;
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = pow2[i - 1] * 2 % MOD;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (pow2[i] - pow2[n - 1 - i]) * nums[i]) % MOD;
        }
        return (ans + MOD) % MOD;
    }
}