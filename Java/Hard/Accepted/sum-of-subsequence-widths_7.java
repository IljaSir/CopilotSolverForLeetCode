class Solution {
    public int sumSubseqWidths(int[] nums) {
        
        int mod = 1000000007;
        Arrays.sort(nums);
        long sum = 0;
        long[] pow = new long[nums.length];
        pow[0] = 1;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + (nums[i] - nums[nums.length - i - 1]) * pow[i] % mod) % mod;
        }
        return (int) sum;
    }
}