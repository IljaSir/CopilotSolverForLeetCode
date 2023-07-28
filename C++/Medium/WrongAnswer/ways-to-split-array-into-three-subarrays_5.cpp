class Solution {
public:
    int waysToSplit(vector<int>& nums) {
        
        int mod = 1000000007;
        int n = nums.size();
        vector<int> sum(n, 0);
        sum[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n - 2; ++i) {
            int left = sum[i];
            int l = i + 1, r = n - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                int right = sum[n - 1] - sum[mid];
                if (right >= left) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int l1 = l;
            l = i + 1, r = n - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                int right = sum[n - 1] - sum[mid];
                if (right > left) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int l2 = l;
            if (l1 <= l2) {
                ans += l2 - l1;
                ans %= mod;
            }
        }
        return ans;
    }
};