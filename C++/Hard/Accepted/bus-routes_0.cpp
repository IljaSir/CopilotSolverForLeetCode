class Solution {
public:
    int numBusesToDestination(vector<vector<int>>& routes, int source, int target) {
        
        if (source == target) return 0;
        unordered_map<int, vector<int>> stops;
        for (int i = 0; i < routes.size(); ++i) {
            for (int j = 0; j < routes[i].size(); ++j) {
                stops[routes[i][j]].push_back(i);
            }
        }
        vector<int> visited(routes.size(), 0);
        queue<int> q;
        q.push(source);
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            ++step;
            for (int i = 0; i < size; ++i) {
                int stop = q.front();
                q.pop();
                for (int j = 0; j < stops[stop].size(); ++j) {
                    if (visited[stops[stop][j]]) continue;
                    visited[stops[stop][j]] = 1;
                    for (int k = 0; k < routes[stops[stop][j]].size(); ++k) {
                        if (routes[stops[stop][j]][k] == target) return step;
                        q.push(routes[stops[stop][j]][k]);
                    }
                }
            }
        }
        return -1;
    }
};