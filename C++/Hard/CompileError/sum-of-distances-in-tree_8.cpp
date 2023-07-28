class Solution {
public:
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        
        // 1. build the graph
        vector<vector<int>> graph(n);
        for (auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        // 2. count the number of nodes in the subtree
        vector<int> count(n, 1);
        vector<int> res(n, 0);
        function<void(int, int)> dfs = [&](int node, int parent) {
            for (auto& child : graph[node]) {
                if (child == parent) continue;
                dfs(child, node);
                count[node] += count[child];
                res[node] += res[child] + count[child];
            }
        };
        dfs(0, -1);
        // 3. calculate the result
        function<void(int, int)> dfs2 = [&](int node, int parent) {
            for (auto& child : graph[node]) {
                if (child == parent) continue;
                res[child] = res[node] - count[child] + n - count[child];
                dfs2(child, node);
            }
        };
        dfs2(0, -1);
        return res;fs2(0, -1{
                    dfs(child, node);
                    count[node] += count[child];
                    sum[node] += sum[child] + count[child];
                }
            }
        };
        function<void(int, int)> dfs2 = [&](int node, int parent) {
            for (int child : graph[node]) {
                if (child != parent) {
                    sum[child] = sum[node] - count[child] + n - count[child];
                    dfs2(child, node);
                }
            }
        };
        dfs(0, -1);
        dfs2(0, -1);
        return sum;
    }
};