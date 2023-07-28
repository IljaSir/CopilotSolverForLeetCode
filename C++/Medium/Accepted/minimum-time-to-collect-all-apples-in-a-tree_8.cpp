class Solution {
public:
    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        
        unordered_map<int, vector<int>> tree;
        for (auto &e: edges) {
            tree[e[0]].push_back(e[1]);
            tree[e[1]].push_back(e[0]);
        }
        vector<bool> visited(n, false);
        return dfs(tree, hasApple, visited, 0);
    }
    
    int dfs(unordered_map<int, vector<int>> &tree, vector<bool> &hasApple, vector<bool> &visited, int root) {
        visited[root] = true;
        int res = 0;
        for (auto &child: tree[root]) {
            if (visited[child]) continue;
            int sub = dfs(tree, hasApple, visited, child);
            if (sub > 0 || hasApple[child]) res += sub + 2;
        }
        return res;
    }
};