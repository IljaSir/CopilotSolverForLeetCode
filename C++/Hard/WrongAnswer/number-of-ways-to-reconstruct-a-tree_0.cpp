class Solution {
public:
    int checkWays(vector<vector<int>>& pairs) {
        
        unordered_map<int, vector<int>> graph;
        unordered_map<int, int> inDegree;
        for (auto& p : pairs) {
            graph[p[0]].push_back(p[1]);
            graph[p[1]].push_back(p[0]);
            inDegree[p[0]]++;
            inDegree[p[1]]++;
        }
        unordered_map<int, int> parents;
        queue<int> q;
        for (auto& p : inDegree)
            if (p.second == 1)
                q.push(p.first);
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int v : graph[u])
                if (--inDegree[v] == 1)
                    q.push(v);
            if (parents.count(u)) {
                int p = parents[u];
                if (graph[p].size() == 1)
                    return 0;
                graph[p].erase(find(graph[p].begin(), graph[p].end(), u));
                graph[u].erase(find(graph[u].begin(), graph[u].end(), p));
                inDegree[u]--;
                inDegree[p]--;
                if (inDegree[p] == 1)
                    q.push(p);
            }
            if (graph[u].size() == 1) {
                int v = graph[u][0];
                parents[v] = u;
            }
        }
        return graph.size() == inDegree.size() ? 1 : 2;
    }
};