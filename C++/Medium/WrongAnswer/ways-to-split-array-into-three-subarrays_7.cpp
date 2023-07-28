class Solution {
public:
    int waysToSplit(vector<int>& nums) {
        
        const int mod = 1000000007;
        int n = nums.size();
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int res = 0;
        for (int i = 1; i <= n - 2; i++) {
            int l = i + 1, r = n - 1;
            int s1 = sum[i];
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                int s2 = sum[mid] - sum[i];
                int s3 = sum[n] - sum[mid];
                if (s1 <= s2 && s2 <= s3) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int s2 = sum[l] - sum[i];
            int s3 = sum[n] - sum[l];
            if (s1 <= s2 && s2 <= s3) {
                res = (res + (l - i)) % mod;
            }
        }
        return res;
    }
};