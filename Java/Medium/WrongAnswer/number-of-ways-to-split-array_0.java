class Solution {
    public int waysToSplitArray(int[] nums) {
        
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            long s = sum[i + 1];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (sum[mid + 1] - s >= s) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int left = l;
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (sum[mid + 1] - s > sum[nums.length] - sum[mid + 1]) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            int right = r;
            if (left <= right) {
                ans = (ans + right - left + 1) % 1000000007;
            }
        }
        return ans;
    }
}