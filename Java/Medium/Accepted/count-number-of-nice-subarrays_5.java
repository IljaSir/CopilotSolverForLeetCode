class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] odd = new int[n + 2];
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                odd[++m] = i;
            }
        }
        odd[0] = -1;
        odd[m + 1] = n;
        int res = 0;
        for (int i = 1; i + k <= m + 1; i++) {
            res += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return res;
    }
}