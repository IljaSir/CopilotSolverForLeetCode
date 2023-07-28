class Solution {
public:
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> graph(n);
        for (auto &edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<int> res(n, 0), count(n, 1);
        dfs(0, -1, graph, count, res);
        dfs2(0, -1, graph, count, res);
        return res;
    }
    void dfs(int node, int parent, vector<vector<int>> &graph, vector<int> &count, vector<int> &res) {
        for (auto &child : graph[node]) {
            if (child == parent) continue;
            dfs(child, node, graph, count, res);
            count[node] += count[child];
            res[node] += res[child] + count[child];
        }
    }
    void dfs2(int node, int parent, vector<vector<int>> &graph, vector<int> &count, vector<int> &res) {
        for (auto &child : graph[node]) {
            if (child == parent) continue;
            res[child] = res[node] - count[child] + count.size() - count[child];
            dfs2(child, node, graph, count, res);
        }
    }
};