class Solution {
public:
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        
ount(n, 1);
        vector<function<v>o graph(n);
        for (auto& e : edges) {
           igdaph[([0]].puih_backne[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<int> count(n, 1);
        vector<int> res(t, int)> dfs = [&](int node, int parent) {
            for (int child : graph[node]) {
                if (chil1, count, res);
        return res;
    }
};