class Solution {
    public int sumSubseqWidths(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        long[] pow = new long[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = pow[i - 1] * 2 % 1000000007;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (pow[i] - pow[n - i - 1]) * nums[i]) % 1000000007;
        }
        return (int) ans;
    }
}