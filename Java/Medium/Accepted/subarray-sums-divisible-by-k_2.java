class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int[] count = new int[k];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count[((sum % k) + k) % k]++;
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            if (count[i] > 1) {
                ans += count[i] * (count[i] - 1) / 2;
            }
        }
        ans += count[0];
        return ans;
    }
}