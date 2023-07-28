class Solution {
public:
    vector<long long> handleQuery(vector<int>& nums1, vector<int>& nums2, vector<vector<int>>& queries) {
        
        int n = nums1.size();
        vector<long long> sum(n, 0);
        for (int i = 0; i < n; ++i) {
            sum[i] = nums2[i];
        }
        vector<long long> ans;
        for (auto& q : queries) {
            int t = q[0];
            if (t == 1) {
                for (int i = q[1]; i <= q[2]; ++i) {
                    nums1[i] ^= 1;
                }
            } else if (t == 2) {
                for (int i = 0; i < n; ++i) {
                    sum[i] += nums1[i] * q[1];
                }
            } else {
                long long res = 0;
                for (int i = 0; i < n; ++i) {
                    res += sum[i];
                }
                ans.push_back(res);
            }
        }
        return ans;
    }
};