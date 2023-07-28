class Solution {
public:
    vector<int> maximizeXor(vector<int>& nums, vector<vector<int>>& queries) {
        
        int n = nums.size();
        int m = queries.size();
        vector<int> ans(m);
        vector<int> idx(m);
        iota(idx.begin(), idx.end(), 0);
        sort(nums.begin(), nums.end());
        sort(idx.begin(), idx.end(), [&](int a, int b){
            return queries[a][1] < queries[b][1];
        });
        int j = 0;
        set<int> s;
        for (int i = 0; i < m; ++i) {
            while (j < n && nums[j] <= queries[idx[i]][1]) {
                s.insert(nums[j]);
                ++j;
            }
            if (s.empty()) ans[idx[i]] = -1;
            else {
                int x = queries[idx[i]][0];
                auto it = s.lower_bound(x);
                if (it != s.end()) ans[idx[i]] = *it ^ x;
                else {
                    --it;
                    ans[idx[i]] = *it ^ x;
                }
            }
        }
        return ans;
    }
};