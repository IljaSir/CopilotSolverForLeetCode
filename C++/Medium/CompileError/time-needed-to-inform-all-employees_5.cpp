class Solution {
public:
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        
        vector<vector<int>> subordinates(n);
        for (int i = 0; i < n; i++) {
            if (i != headID) {
                subordinates[manager[i]].push_back(i);
            }
        }
        return dfs(headID, subordinates, informTime);
    }
};