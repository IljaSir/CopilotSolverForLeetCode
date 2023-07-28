class Solution {
    public int waysToSplitArray(int[] nums) {
        
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int j = 1;
        int k = 1;
        long res = 0;
        for (int i = 1; i < n; i++) {
            while (j <= i && sum[j] - sum[0] < sum[i + 1] - sum[j]) {
                j++;
            }
            while (k < i && sum[i + 1] - sum[k] >= sum[k] - sum[0]) {
                k++;
            }
            if (j <= k && k <= i) {
                res += k - j + 1;
            }
        }
        return (int) (res % 1000000007);
    }
}