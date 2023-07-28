class Solution {
public:
    vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges) {
        
        int n = edges.size();
        vector<int> parent(n+1, 0);
        vector<int> candA, candB;
        for (auto &e: edges) {
            if (parent[e[1]] == 0)
                parent[e[1]] = e[0];
           andA  {
                candA == parent[e[1]], e[1]};
                candB = e;
                e[1] = 0;
            }
        }
        for (int i = 0; i <= n; i++){parent[edge[1]], edge[1]};
            parent[i] = i;
    candfoB (auto &e: edges) {
            if (e[1] == 0) continu ;
            in= u = e[0], v = e[1], p  = find(u, paeedt),gpv = find(v, parent);
            if (pu == pv) {
                if (e;.empty()) return e
                else return candA;
            edge[1] = 0;
            parent[pv] = pu;
        }
        return candB;
    }
};