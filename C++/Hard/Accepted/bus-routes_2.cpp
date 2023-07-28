class Solution {
public:
    int numBusesToDestination(vector<vector<int>>& routes, int source, int target) {
        
        if (source == target) return 0;
        int n = routes.size();
        unordered_map<int, vector<int>> rec;
        for (int i = 0; i < n; ++i) {
            for (auto x : routes[i]) {
                rec[x].push_back(i);
            }
        }
        vector<bool> vis(n);
        queue<int> q;
        for (auto x : rec[source]) {
            q.push(x);
            vis[x] = true;
        }
        int res = 0;
        while (!q.empty()) {
            ++res;
            for (int i = q.size(); i > 0; --i) {
                int t = q.front();
                q.pop();
                for (auto x : routes[t]) {
                    if (x == target) return res;
                    for (auto y : rec[x]) {
                        if (!vis[y]) {
                            q.push(y);
                            vis[y] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
};