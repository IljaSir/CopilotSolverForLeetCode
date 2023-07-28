class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int[] mods = new int[k];
        mods[0] = 1;
        int sum = 0;
        int result = 0;
        for (int num : nums) {
            sum += num;
            int mod = (sum % k + k) % k;
            result += mods[mod];
            mods[mod]++;
        }
        return result;
    }
}