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
    
    int dfs(int id, vector<vector<int>>& subordinates, vector<int>& informTime) {
        int maxTime = 0;
        for (int subId: subordinates[id]) {
            maxTime = max(maxTime, dfs(subId, subordinates, informTime));
        }
        return maxTime + informTime[id];
    }
};