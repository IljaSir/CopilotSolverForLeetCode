class Solution {
public:
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        
        unordered_map<int, vector<int>> m;
        for (int i = 0; i < n; ++i) {
            if (i != headID) {
                m[manager[i]].push_back(i);
            }
        }
        int res = 0;
        queue<pair<int, int>> q;
        q.push({headID, 0});
        while (!q.empty()) {
            auto [id, time] = q.front();
            q.pop();
            res = max(res, time);
            for (auto i : m[id]) {
                q.push({i, time + informTime[id]});
            }
        }
        return res;
    }
};