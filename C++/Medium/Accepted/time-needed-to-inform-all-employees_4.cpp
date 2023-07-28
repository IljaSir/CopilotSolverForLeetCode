class Solution {
public:
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        
        vector<vector<int>> tree(n);
        for (int i = 0; i < n; i++) {
            if (manager[i] == -1) continue;
            tree[manager[i]].push_back(i);
        }
        int ans = 0;
        queue<pair<int, int>> q;
        q.push({headID, 0});
        while (!q.empty()) {
            auto [id, time] = q.front(); q.pop();
            ans = max(ans, time);
            for (auto child: tree[id]) {
                q.push({child, time + informTime[id]});
            }
        }
        return ans;
    }
};