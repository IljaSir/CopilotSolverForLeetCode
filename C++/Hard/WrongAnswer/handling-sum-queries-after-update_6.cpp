class Solution {
public:
    vector<long long> handleQuery(vector<int>& nums1, vector<int>& nums2, vector<vector<int>>& queries) {
        
        int n = nums1.size();
        vector<long long> res;
        vector<long long> sum(n+1);
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums2[i-1];
        }
        for (auto& query : queries) {
            if (query[0] == 1) {
                for (int i = query[1]; i <= query[2]; i++) {
                    nums1[i] = 1 - nums1[i];
                }
            } else if (query[0] == 2) {
                for (int i = 1; i <= n; i++) {
                    nums2[i-1] += nums1[i-1] * query[1];
                    sum[i] = sum[i-1] + nums2[i-1];
                }
            } else {
                res.push_back(sum[query[2]+1] - sum[query[1]]);
            }
        }
        return res;
    }
};