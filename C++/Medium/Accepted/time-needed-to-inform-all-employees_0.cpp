class Solution {
public:
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        
        vector<vector<int>> tree(n);
        for (int i = 0; i < n; ++i) {
            if (manager[i] != -1) {
                tree[manager[i]].push_back(i);
            }
        }
        return dfs(tree, informTime, headID);
    }
    
    int dfs(vector<vector<int>>& tree, vector<int>& informTime, int root) {
        int res = 0;
        for (int child: tree[root]) {
            res = max(res, dfs(tree, informTime, child));
        }
        return res + informTime[root];
    }
};