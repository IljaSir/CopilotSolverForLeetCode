class Solution {
public:
    vector<int> maxGeneticDifference(vector<int>& parents, vector<vector<int>>& queries) {
        
        int n = parents.size();
        vector<vector<int>> children(n);
        int root = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) {
                root = i;
            } else {
                children[parents[i]].push_back(i);
            }
        }
        vector<int> ans(queries.size());
        vector<int> node2idx(n);
        vector<int> node2val(n);
        unordered_map<int, vector<int>> node2queryIdx;
        for (int i = 0; i < queries.size(); i++) {
            int node = queries[i][0];
            int val = queries[i][1];
            node2queryIdx[node].push_back(i);
            node2val[node] = val;
        }
        dfs(root, children, node2idx, node2val, node2queryIdx, ans);
        return ans;
    }
    int dfs(int node, vector<vector<int>>& children, vector<int>& node2idx, vector<int>& node2val, unordered_map<int, vector<int>>& node2queryIdx, vector<int>& ans) {
        int idx = node2idx[node] = node2idx[parents[node]] + 1;
        int val = node2val[node];
        int maxDiff = 0;
        for (int i = 0, j = 31; i < 32; i++, j--) {
            if (val & (1 << i)) {
                int idx = node2idx[node] - (1 << j);
                if (idx >= 0) {
                    maxDiff = max(maxDiff, val ^ (1 << i));
                }
            }
        }
        for (int child : children[node]) {
            maxDiff = max(maxDiff, dfs(child, children, node2idx, node2val, node2queryIdx, ans));
        }
        for (int queryIdx : node2queryIdx[node]) {
            ans[queryIdx] = maxDiff;
        }
        return maxDiff;
    }
};