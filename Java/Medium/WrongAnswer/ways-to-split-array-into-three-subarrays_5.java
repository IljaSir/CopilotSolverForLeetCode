class Solution {
    public int waysToSplit(int[] nums) {
        
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int res = 0;
        int mod = 1000000007;
        for (int i = 0; i < len - 2; i++) {
            int l = i + 1;
            int r = len - 1;
            int leftSum = sum[i + 1];
            while (l < r) {
                int mid = (r - l) / 2 + l;
                int midSum = sum[mid + 1] - sum[i + 1];
                int rightSum = sum[len] - sum[mid + 1];
                if (leftSum > midSum) {
                    l = mid + 1;
                } else if (midSum > rightSum) {
                    r = mid;
                } else {
                    r = mid;
                }
            }
            if (sum[l + 1] - sum[i + 1] >= leftSum) {
                res = (res + l - i) % mod;
            }
        }
        return res;
    }
}