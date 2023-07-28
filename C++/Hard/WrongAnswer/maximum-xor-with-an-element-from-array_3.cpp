class Solution {
public:
    vector<int> maximizeXor(vector<int>& nums, vector<vector<int>>& queries) {
        
        int n = nums.size();
        int m = queries.size();
        vector<int> ans(m);
        vector<pair<int, int>> q(m);
        for (int i = 0; i < m; i++) {
            q[i] = {queries[i][1], i};
        }
        sort(q.begin(), q.end());
        sort(nums.begin(), nums.end());
        int j = 0;
        for (auto& p : q) {
            int x = p.first;
            int idx = p.second;
            int max_xor = -1;
            for (; j < n; j++) {
                if (nums[j] > x) break;
                max_xor = max(max_xor, nums[j] ^ queries[idx][0]);
            }
            ans[idx] = max_xor;
        }
        return ans;
    }
};