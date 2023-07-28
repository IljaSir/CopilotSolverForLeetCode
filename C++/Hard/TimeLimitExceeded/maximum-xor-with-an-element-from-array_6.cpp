class Solution {
public:
    vector<int> maximizeXor(vector<int>& nums, vector<vector<int>>& queries) {
        
        int n = nums.size();
        int q = queries.size();
        sort(nums.begin(), nums.end());
        vector<int> res(q);
        vector<int> idx(q);
        for (int i = 0; i < q; ++i) {
            idx[i] = i;
        }
        sort(idx.begin(), idx.end(), [&](int i, int j) {
            return queries[i][1] < queries[j][1];
        });
        int j = 0;
        for (int i = 0; i < q; ++i) {
            int x = queries[idx[i]][0];
            int m = queries[idx[i]][1];
            while (j < n && nums[j] <= m) {
                ++j;
            }
            if (j == 0) {
                res[idx[i]] = -1;
            } else {
                int max = 0;
                for (int k = 0; k < j; ++k) {
                    max = std::max(max, x ^ nums[k]);
                }
                res[idx[i]] = max;
            }
        }
        return res;
    }
};