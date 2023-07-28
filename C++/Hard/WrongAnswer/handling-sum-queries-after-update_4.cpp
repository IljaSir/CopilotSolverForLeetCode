class Solution {
public:
    vector<long long> handleQuery(vector<int>& nums1, vector<int>& nums2, vector<vector<int>>& queries) {
        
        vector<long long> ans;
        vector<long long> sum(nums2.size(), 0);
        for (int i = 0; i < nums2.size(); i++) {
            sum[i] = nums2[i];
            if (i) sum[i] += sum[i - 1];
        }
        vector<long long> diff(nums2.size(), 0);
        for (int i = 0; i < queries.size(); i++) {
            if (queries[i][0] == 1) {
                for (int j = queries[i][1]; j <= queries[i][2]; j++) {
                    nums1[j] ^= 1;
                    diff[j] = -diff[j];
                }
            } else if (queries[i][0] == 2) {
                for (int j = queries[i][1]; j < nums2.size(); j++) {
                    diff[j] += queries[i][2];
                }
            } else {
                ans.push_back(sum[queries[i][2]]);
                if (queries[i][1]) ans.back() -= sum[queries[i][1] - 1];
                for (int j = queries[i][1]; j <= queries[i][2]; j++) {
                    ans.back() += diff[j] * nums1[j];
                }
            }
        }
        return ans;
    }
};