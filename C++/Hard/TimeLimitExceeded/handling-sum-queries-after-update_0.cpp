class Solution {
public:
    vector<long long> handleQuery(vector<int>& nums1, vector<int>& nums2, vector<vector<int>>& queries) {
        
        vector<long long> result;
        for (auto& query : queries) {
            if (query[0] == 1) {
                for (int i = query[1]; i <= query[2]; ++i) {
                    nums1[i] = 1 - nums1[i];
                }
            } else if (query[0] == 2) {
                for (int i = 0; i < nums1.size(); ++i) {
                    nums2[i] += nums1[i] * query[1];
                }
            } else {
                long long sum = 0;
                for (int i = 0; i < nums2.size(); ++i) {
                    sum += nums2[i];
                }
                result.push_back(sum);
            }
        }
        return result;
    }
};