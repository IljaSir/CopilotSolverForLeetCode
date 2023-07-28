class Solution {
public:
    vector<long long> handleQuery(vector<int>& nums1, vector<int>& nums2, vector<vector<int>>& queries) {
        
        vector<long long> res;
        int n = nums1.size();
        int m = queries.size();
        long long s = 0;
        for (int i = 0; i < n; ++i) {
            s += nums2[i];
        }
        for (int i = 0; i < m; ++i) {
            if (queries[i][0] == 1) {
                int l = queries[i][1];
                int r = queries[i][2];
                for (int j = l; j <= r; ++j) {
                    nums1[j] = 1 - nums1[j];
                    s += (1 - 2 * nums1[j]) * nums2[j];
                }
            } else if (queries[i][0] == 2) {
                int p = queries[i][1];
                s += 1LL * n * p;
            } else {
                res.push_back(s);
            }
        }
        return res;
    }
};