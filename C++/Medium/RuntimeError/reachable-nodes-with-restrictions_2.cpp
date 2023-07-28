class Solution {
public:
    int reachableNodes(int n, vector<vector<int>>& edges, vector<int>& restricted) {
        
        unordered_map<int, unordered_map<int, int>> m;
        for (auto &e : edges) {
            m[e[0]][e[1]] = e[2];
            m[e[1]][e[0]] = e[2];
        }
        
        unordered_set<int> visited;
        visited.insert(0);
        int res = 0;
        queue<pair<int, int>> q;
        q.push({0, INT_MAX});
        while (!q.empty()) {
            auto t = q.front(); q.pop();
            res++;
            for (auto &p : m[t.first]) {
                if (visited.find(p.first) != visited.end()) continue;
                visited.insert(p.first);
                int n = min(t.second, p.second);
                if (n > 0) {
                    q.push({p.first, n-1});
                    res += n;
                }
            }
        }
        
        for (auto &e : edges) {
            int a = e[0], b = e[1], l = e[2];
            int x = 0, y = 0;
            if (visited.find(a) != visited.end()) x = min(l, restricted[a]);
            if (visited.find(b) != visited.end()) y = min(l, restricted[b]);
            res -= (x+y);
        }
        
        return res;
    }
};