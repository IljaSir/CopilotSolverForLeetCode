class Solution {
public:
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        
        vector<vector<int>> tree(n);
        for (int i = 0; i < n; ++i) {
            if (manager[i] != -1) {
                tree[manager[i]].push_back(i);
            }
        }
        
        return dfs(tree, headID, informTime);
    }
    
    int dfs(vector<vector<int>>& tree, int root, vector<int>& informTime) {
        int ans = 0;
        for (auto child : tree[root]) {
            ans = max(ans, dfs(tree, child, informTime));
        }
        return ans + informTime[root];
    }
};