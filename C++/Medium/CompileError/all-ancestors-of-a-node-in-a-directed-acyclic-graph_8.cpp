class Solution {
public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        
cestor

        vector<vector<int>> ancestors(n);
        vector<vector<int>> graph(n);
        vector<int> indeg(n, 0);
        for (auto edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            indeg[edge[1]] += 1;
        }
        // cout << "graph: " << endl;
        // for (auto v : graph) {
        //     cout << v << endl;
        // }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            for (int nei : graph[node]) {
                ancestors[nei].push_back(node);
                for (int anc : ancestors[node]) {
                    ancestors[nei].push_back(anc);
                }
                sort(ancestors[nei].begin(), ancestors[nei].end());
                indeg[nei] -= 1;
                if (indeg[nei] == 0) {
                    q.push(nei);
                }
            }
        }
        return ancestors;
    }
};