class Solution {
public:
    int numBusesToDestination(vector<vector<int>>& routes, int source, int target) {
        
        if (source == target) return 0;
        unordered_map<int, vector<int>> m;
        for (int i = 0; i < routes.size(); ++i) {
            for (auto j : routes[i]) {
                m[j].push_back(i);
            }
        }
        vector<int> visited(routes.size(), 0);
        queue<int> q;
        q.push(source);
        int step = 0;
        while (!q.empty()) {
            ++step;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int t = q.front();
                q.pop();
                for (auto j : m[t]) {
                    if (visited[j] == 1) continue;
                    visited[j] = 1;
                    for (auto k : routes[j]) {
                        if (k == target) return step;
                        q.push(k);
                    }
                }
            }
        }
        return -1;
    }
};