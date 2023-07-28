class Solution {
public:
    vector<int> maximizeXor(vector<int>& nums, vector<vector<int>>& queries) {
        
        int n = nums.size();
        int q = queries.size();
        vector<int> ans(q);
        vector<int> idx(q);
        for (int i = 0; i < q; ++i) {
            idx[i] = i;
        }
        sort(begin(nums), end(nums));
        sort(begin(idx), end(idx), [&](int i, int j) {
            return queries[i][1] < queries[j][1];
        });
        int i = 0;
        Trie trie;
        for (int j = 0; j < q; ++j) {
            while (i < n && nums[i] <= queries[idx[j]][1]) {
                trie.insert(nums[i]);
                ++i;
            }
            ans[idx[j]] = trie.search(queries[idx[j]][0]);
        }
        return ans;
    }
};