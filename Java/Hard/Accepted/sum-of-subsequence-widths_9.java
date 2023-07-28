class Solution {
    public int sumSubseqWidths(int[] nums) {
        
        Arrays.sort(nums);
        long c = 1, result = 0, mod = 1000000007;
        for(int i = 0; i < nums.length; i++){
            result = (result + nums[i] * c - nums[nums.length - 1 - i] * c) % mod;
            c = c * 2 % mod;
        }
        return (int)((result + mod) % mod);
    }
}