class Solution {
public:
    vector<long long> handleQuery(vector<int>& nums1, vector<int>& nums2, vector<vector<int>>& queries) {
        
        vector<long long> ans;
        int n = nums1.size();
        vector<long long> sum(n, 0);
        for (int i = 0; i < n; i++) {
            sum[i] = nums2[i];
            if (i) sum[i] += sum[i - 1];
        }
        for (auto& q : queries) {
            if (q[0] == 1) {
                for (int i = q[1]; i <= q[2]; i++) {
                    nums1[i] ^= 1;
                    if (nums1[i]) {
                        sum[i] += nums2[i];
                    } else {
                        sum[i] -= nums2[i];
                    }
                }
            } else if (q[0] == 2) {
                for (int i = 0; i < n; i++) {
                    nums2[i] += nums1[i] * q[1];
                    if (nums1[i]) {
                        sum[i] += nums2[i];
                    } else {
                        sum[i] -= nums2[i];
                    }
                }
            } else {
                int l = q[1], r = q[2];
                if (l == 0) {
                    ans.push_back(sum[r]);
                } else {
                    ans.push_back(sum[r] - sum[l - 1]);
                }
            }
        }
        return ans;
    }
};