class Solution {
    public long beautifulSubarrays(int[] nums) {
        
        int len = nums.length;
        int[] odd = new int[len + 2];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 1) {
                odd[++count] = i;
            }
        }
        odd[0] = -1;
        odd[count + 1] = len;
        long ans = 0;
        for (int i = 1; i <= count; i++) {
            ans += (long) (odd[i] - odd[i - 1]) * (odd[i + 1] - odd[i]);
        }
        return ans;
    }
}