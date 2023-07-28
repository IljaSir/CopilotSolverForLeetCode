class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int[] mod = new int[k];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            mod[((sum % k) + k) % k]++;
        }
        int res = mod[0];
        for (int i : mod) res += i * (i - 1) / 2;
        return res;
    }
}