class Solution {
public:
    vector<long long> handleQuery(vector<int>& nums1, vector<int>& nums2, vector<vector<int>>& queries) {
        
        int n = nums1.size();
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + nums1[i];
        }
        vector<long long> ans;
        for (auto& q : queries) {
            if (q[0] == 1) {
                for (int i = q[1] + 1; i <= q[2] + 1; ++i) {
                    nums1[i - 1] ^= 1;
                }
                for (int i = q[1] + 1; i <= n; ++i) {
                    sum[i] = sum[i - 1] + nums1[i - 1];
                }
            } else if (q[0] == 2) {
                ans.push_back(1ll * sum[q[2] + 1] * q[1]);
            } else {
                ans.push_back(1ll * sum[n] * q[1]);
            }
        }
        return ans;
    }
};