class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sum(n + 1);
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            int l = i + 1, r = n;
            while (l < r) {
                int mid = (l + r) / 2;
                if (sum[mid] - sum[i] >= sum[i]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int j = l;
            l = i + 1, r = n;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (sum[mid] - sum[i] <= sum[n] - sum[mid]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int k = l;
            if (j <= k) {
                ans = (ans + k - j + 1) % 1000000007;
            }
        }
        return ans;
    }
};