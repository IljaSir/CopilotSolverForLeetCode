class Solution {
    public long beautifulSubarrays(int[] nums) {
        
        long res = 0;
        int[] odd = new int[nums.length + 2];
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                odd[++cnt] = i;
            }
        }
        odd[0] = -1;
        odd[cnt + 1] = nums.length;
        for (int i = 1; i <= cnt; i++) {
            res += (long)(odd[i] - odd[i - 1]) * (odd[i + 1] - odd[i]);
        }
        return res;
    }
}