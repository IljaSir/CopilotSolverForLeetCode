class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int[] mod = new int[k];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            mod[((sum % k) + k) % k]++;
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            if (mod[i] > 1) {
                res += (mod[i] * (mod[i] - 1)) / 2;
            }
        }
        return res + mod[0];
    }
}