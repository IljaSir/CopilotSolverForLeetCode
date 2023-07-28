class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int[] count = new int[nums.length + 1];
        count[0] = 1;
        int odd = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            odd += nums[i] % 2;
            if (odd >= k) {
                res += count[odd - k];
            }
            count[odd]++;
        }
        return res;
    }
}