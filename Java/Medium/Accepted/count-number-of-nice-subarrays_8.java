class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] oddIndex = new int[n + 2];
        int odd = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                oddIndex[++odd] = i;
            }
        }
        oddIndex[0] = -1;
        oddIndex[odd + 1] = n;
        int res = 0;
        for (int i = 1; i + k <= odd + 1; i++) {
            res += (oddIndex[i] - oddIndex[i - 1]) * (oddIndex[i + k] - oddIndex[i + k - 1]);
        }
        return res;
    }
}