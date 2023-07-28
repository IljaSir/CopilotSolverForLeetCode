class Solution {
public:
    vector<long long> handleQuery(vector<int>& nums1, vector<int>& nums2, vector<vector<int>>& queries) {
        
        vector<long long> res;
        for (auto &q : queries) {
            if (q[0] == 1) {
                for (int i = q[1]; i <= q[2]; i++) {
                    nums1[i] = 1 - nums1[i];
                }
            } else if (q[0] == 2) {
                for (int i = 0; i < nums1.size(); i++) {
                    nums2[i] += q[1] * nums1[i];
                }
            } else {
                long long sum = 0;
                for (int i = 0; i < nums2.size(); i++) {
                    sum += nums2[i];
                }
                res.push_back(sum);
            }
        }
        return res;
    }
};