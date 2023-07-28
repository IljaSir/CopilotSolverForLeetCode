class Solution {
    public int sumSubseqWidths(int[] nums) {
        
        Arrays.sort(nums);
        long[] pows = new long[nums.length];
        pows[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pows[i] = pows[i - 1] * 2 % 1000000007;
        }
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = (res + nums[i] * (pows[i] - pows[nums.length - i - 1])) % 1000000007;
        }
        return (int) res;
    }
}