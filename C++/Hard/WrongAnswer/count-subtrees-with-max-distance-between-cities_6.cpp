class Solution {
public:
    vector<int> countSubgraphsForEachDiameter(int n, vector<vector<int>>& edges) {
        
        vector<int> res(n-1, 0);
        for (int mask = 1; mask < (1<<n); mask++) {
            vector<int> v;
            for (int i = 0; i < n; i++) {
                if (mask & (1 << i)) {
                    v.push_back(i);
                }
            }
            if (v.size() <= 1) {
                continue;
            }
            int dist = 0;
            for (int i = 0; i < v.size(); i++) {
                for (int j = i+1; j < v.size(); j++) {
                    dist = max(dist, getDist(n, edges, mask, v[i], v[j]));
                }
            }
            res[dist-1]++;
        }
        return res;
    }
    
    int getDist(int n, vector<vector<int>>& edges, int mask, int u, int v) {
        int dist = 0;
        vector<int> visited(n, 0);
        queue<int> q;
        q.push(u);
        visited[u] = 1;
        while (!q.empty()) {
            int size = q.size();
            dist++;
            for (int i = 0; i < size; i++) {
                int cur = q.front();
                q.pop();
                for (int j = 0; j < edges.size(); j++) {
                    if (edges[j][0] == cur+1 && mask & (1 << (edges[j][1]-1))) {
                        if (!visited[edges[j][1]-1]) {
                            q.push(edges[j][1]-1);
                            visited[edges[j][1]-1] = 1;
                        }
                    }
                    if (edges[j][1] == cur+1 && mask & (1 << (edges[j][0]-1))) {
                        if (!visited[edges[j][0]-1]) {
                            q.push(edges[j][0]-1);
                            visited[edges[j][0]-1] = 1;
                        }
                    }
                }
            }
            if (visited[v]) {
                break;
            }
        }
        return dist;
    }
};