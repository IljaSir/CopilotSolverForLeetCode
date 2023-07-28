class Solution {
public:
    vector<long long> handleQuery(vector<int>& nums1, vector<int>& nums2, vector<vector<int>>& queries) {
        
        int n = nums1.size();
        vector<long long> res;
        vector<long long> sum(n + 1, 0);
        int flip = 0;
        for (auto& q : queries) {
            if (q[0] == 1) {
                flip ^= 1;
            } else if (q[0] == 2) {
                int p = q[1];
                if (flip == 0) {
                    sum[0] += p;
                    sum[q[1] + 1] -= p;
                } else {
                    sum[0] -= p;
                    sum[q[1] + 1] += p;
                }
            } else {
                long long sum1 = 0;
                for (int i = 0; i < n; ++i) {
                    sum1 += nums1[i];
                }
                long long sum2 = 0;
                for (int i = 0; i < n; ++i) {
                    sum2 += nums2[i];
                }
                if (flip == 0) {
                    res.push_back(sum1 + sum2);
                } else {
                    res.push_back(sum1 - sum2);
                }
            }
        }
        long long cur = 0;
        for (int i = 0; i < n; ++i) {
            cur += sum[i];
            nums2[i] += cur;
        }
        return res;
    }
};