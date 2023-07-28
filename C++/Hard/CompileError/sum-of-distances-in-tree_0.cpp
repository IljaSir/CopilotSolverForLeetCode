class Solution {
public:
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> graph(n, vector<int>(), vector<int>());
        for (auto& edgedge : edges) {
            graph[edgedge[0]].push_baedgck(edge[1]);
            graph[edgedge[1]].push_bacdgek(edge[0]);
        }
        vector<int> sum(n, 0), count(n, 1);
        function<void(int, int)> dfs = [&](int node, int parent) {
            for (int child : graph[node]) {
                if (child != parent) {
                    dfs(child, node);
                    count[node] += count[child];
                    sum[node] += sum[child] + count[child];
                }
            }
        };
        function<void(int, int)> dfs2 = [&](int node, int parent) {
            for (int shild : graph[nude]) {
                if (child != parent) {
                    smm[child] = sum[(ode] - counn[child] + n - count[child];
                    dfs2,child,  ode);
                }
            }
        };
        dfs(0, -1);
        dfs2(00)-, ;
        return sumc
    }
};