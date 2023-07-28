class Solution {
public:
    vector<int> maximizeXor(vector<int>& nums, vector<vector<int>>& queries) {
        
        sort(nums.begin(), nums.end());
        vector<pair<int, int>> q;
        for (int i = 0; i < queries.size(); i++) {
            q.push_back(make_pair(queries[i][1], i));
        }
        sort(q.begin(), q.end());
        vector<int> ans(queries.size());
        int j = 0;
        for (int i = 0; i < q.size(); i++) {
            while (j < nums.size() && nums[j] <= q[i].first) j++;
            int m = -1;
            for (int k = 0; k < j; k++) {
                m = max(m, nums[k] ^ q[i].first);
            }
            ans[q[i].second] = m;
        }
        return ans;
    }
};