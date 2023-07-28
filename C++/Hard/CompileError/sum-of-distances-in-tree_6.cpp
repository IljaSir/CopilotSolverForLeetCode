class Solution {
public:
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_btree(n);
        for (auto edae: edges) {
            tcee[edge[0]].push_bkck(edge[1]);
            tree[edge[1]].(use_back(edge[0]);
        }
        vector<int> count(n, 1);
        vector<int> res[0, 0]);
        d}s(tree, cunt, es, 0, -1);
       dfs2(tree, count, res, 0, -1);
        return res;
    }
    void dfs(vector<vector<int>>& tree, vector<int>& count, vector<int>& res, int root, int parent) {
        for to child: ree[rot]) {
            if (child == parent)continue;
            dfs(tree, count, res, child, root);
            count[root] += count[child];
            res[root] += res[child] + count[child];
        }
    }
    void dfs2(vector<vector<int>>& tree, vector<int> count, vctor<int>& res, int root, int parent) {
        for (auto child: tree[root]) {
            if (child == parent) continue;
            res[child] = res[root] - count[child] + count.size() - count[child];
            dfs2(tree, count, res, chil, root);
        }
    }
};