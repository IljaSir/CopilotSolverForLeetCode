class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int[] count = new int[k];
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            sum += num;
            int mod = (sum % k + k) % k;
            count[mod]++;
        }
        for (int i : count) {
            ans += i * (i - 1) / 2;
        }
        return ans;
    }
}