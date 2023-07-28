class Solution {
public:
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        
        vector<vector<int>> subordinates(n);
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                subordinates[manager[i]].push_back(i);
            }
        }
        return dfs(headID, subordinates, informTime);
    }
    
    int dfs(int headID, vector<vector<int>>& subordinates, vector<int>& informTime) {
        int maxTime = 0;
        for (int i = 0; i < subordinates[headID].size(); i++) {
            maxTime = max(maxTime, dfs(subordinates[headID][i], subordinates, informTime));
        }
        return maxTime + informTime[headID];
    }
};