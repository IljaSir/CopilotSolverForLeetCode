class Solution {
public:
    int numBusesToDestination(vector<vector<int>>& routes, int source, int target) {
        
        if (source == target) return 0;
        unordered_map<int, vector<int>> bus;
        for (int i = 0; i < routes.size(); ++i) {
            for (int j = 0; j < routes[i].size(); ++j) {
                bus[routes[i][j]].push_back(i);
            }
        }
        vector<int> visited(routes.size(), 0);
        queue<int> q;
        for (int i = 0; i < bus[source].size(); ++i) {
            q.push(bus[source][i]);
            visited[bus[source][i]] = 1;
        }
        int res = 1;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int cur = q.front();
                q.pop();
                for (int j = 0; j < routes[cur].size(); ++j) {
                    if (routes[cur][j] == target) return res;
                    for (int k = 0; k < bus[routes[cur][j]].size(); ++k) {
                        if (visited[bus[routes[cur][j]][k]] == 0) {
                            q.push(bus[routes[cur][j]][k]);
                            visited[bus[routes[cur][j]][k]] = 1;
                        }
                    }
                }
            }
            ++res;
        }
        return -1;
    }
};