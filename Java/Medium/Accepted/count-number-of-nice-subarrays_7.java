class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int[] odd = new int[nums.length + 2];
        int t = 0;
        odd[t++] = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                odd[t++] = i;
            }
        }
        odd[t++] = nums.length;
        int res = 0;
        for (int i = 1; i + k < t; i++) {
            res += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return res;
    }
}