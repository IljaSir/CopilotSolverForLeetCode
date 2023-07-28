class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = i;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] * 2 <= nums[i]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            dp[i] = l > 0 ? dp[l - 1] + 1 : 1;
            count[dp[i] - 1]++;
            res = Math.max(res, dp[i]);
        }
        int ans = 0;
        for (int i = res - 1; i >= 0; i--) {
            ans += count[i];
        }
        return ansnum]++;
        }
        int[] sum = new int[1000001];
        for (int i = 1; i < 1000001; i++) {
            sum[i] = sum[i - 1] + count[i];
        }
        int ans = 0;
        for (int i = 1; i < 1000001; i++) {
            int j = i << 1;
            int cnt = 0;
            while (j < 1000001) {
                cnt += sum[j] - sum[i];
                j <<= 1;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}