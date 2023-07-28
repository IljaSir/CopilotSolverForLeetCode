class Solution {
    public int createSortedArray(int[] instructions) {
        
        int[] nums = new int[100001];
        int res = 0;
        int mod = 1000000007;
        for (int i = 0; i < instructions.length; ++i) {
            int l = 0;
            for (int j = 1; j < instructions[i]; ++j) {
                l += nums[j];
            }
            int r = i - l - nums[instructions[i]];
            res = (res + Math.min(l, r)) % mod;
            nums[instructions[i]] += 1;
        }
        return res;
    }
}