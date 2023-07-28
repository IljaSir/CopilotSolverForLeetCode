class Solution {
public:
    int waysToSplit(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int ans = 0;
        for (int i = 1; i < n - 1; ++i) {
            int l = 0, r = i - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (sum[i] - sum[m] >= sum[m + 1]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            int left = l;
            l = i + 1, r = n - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (sum[m] - sum[i] > sum[n] - sum[m + 1]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            int right = l;
            if (sum[i] - sum[left] >= sum[left + 1] && sum[right] - sum[i] >= sum[n] - sum[right + 1]) {
                ans += right - left;
                ans %= 1000000007;
            }
        }
        return ans;
    }
};