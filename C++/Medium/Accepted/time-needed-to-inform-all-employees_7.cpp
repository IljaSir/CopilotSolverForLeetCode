class Solution {
public:
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        
        vector<vector<int>> tree(n);
        for (int i = 0; i < n; ++i) {
            if (i == headID) continue;
            tree[manager[i]].push_back(i);
        }
        int ans = 0;
        queue<pair<int, int>> q;
        q.emplace(headID, 0);
        while (!q.empty()) {
            auto [id, t] = q.front();
            q.pop();
            ans = max(ans, t);
            for (auto c : tree[id]) {
                q.emplace(c, t + informTime[id]);
            }
        }
        return ans;
    }
};