class Solution {
public:
    vector<bool> friendRequests(int n, vector<vector<int>>& restrictions, vector<vector<int>>& requests) {
        
        vector<bool> res(requests.size(), true);
        vector<vector<int>> g(n);
        for (auto &r: restrictions) {
            g[r[0]].push_back(r[1]);
            g[r[1]].push_back(r[0]);
        }
        vector<int> indeg(n);
        for (auto &r: requests) {
            queue<int> q;
            vector<bool> visited(n);
            q.push(r[0]);
            visited[r[0]] = true;
            while (!q.empty()) {
                int u = q.front();
                q.pop();
                for (int v: g[u]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.push(v);
                    }
                }
            }
            if (visited[r[1]]) {
                res.push_back(false);
            }
            for (int i = 0; i < n; ++i) {
                if (visited[i]) {
                    indeg[i]++;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (indeg[i] > 1) {
                for (int j = 0; j < res.size(); ++j) {
                    if (requests[j][0] == i || requests[j][1] == i) {
                        res[j] = false;
                    }
                }
            }
        }
        return res;
    }
};