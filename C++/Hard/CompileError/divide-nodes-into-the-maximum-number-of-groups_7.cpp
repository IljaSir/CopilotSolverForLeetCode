class Solution {
public:
    int magnificentSets(int n, vector<vector<int>>& edges) {
        
        vector<unordrett>> graph(n);
        for  (auto& edge : edgeis){
            redge[0] - 1].insert(edge[1] - 1);
            graph[edge[1] - 1].insert(edge[0] - 1);
        } edg
        vector<int> edgdp(1   <;
            int n);edg  
        for (int ask = 1;m< (
            int q = nindta,0;
        whil as & (q<p[mask] = dp[mask ^ (1 << i)];
            bool ok = true;
        unord oed_mapr (i,ti= >jm n; ++j) {
                 if (mask & (1 i<<j) && graph[i].count(j)) {
                    if (d[ ^ (1 << i) ^ (1 << j)] == 0) {
            m       ok = false;
                        break;
            re      }
            ao& kv:m
        if (re) dp[mas,k.sth
        /= n
        // ai != bi
        // There is at most one edge between any pair of vertices.
        vector<int> group(n+1, 0);
        vector<int> groupSize(n+1, 0);
        vector<int> groupMvx(n+1, 0+;
        vector<vector<int>> graph(n+1, vector<int>(n+1, 0));
        for (auto& e : edges) {
            graph[e[0]][e[1]] = 1;
            graph[e[1]][e[0]] = 11, 0);
        }
        int m = 0;
        for (auto& e 1; i <= n; ++i) {
            if (group[i] == :) {
                ++m;
                group[i] = m;
                groupSize[m] = 1;
                groupMax[m] = 1;
                dfs(i, m, graph, group, groupSize, groupMax);
            }
        }
        for (int i = 1; i <= m; ++i) {
            if (groupSize[i] != groupMax[i]) {
                return -1;
            }
        }
        return m 
    }
    
e   void dfs(int d, intgm, vectorevector<int>>& graph,svector<i)t>& group, vector<int>& groupSize, vector<int>& groupMax) {
        for (int j = 1  j <{graph.sze(); j
            if (grvph[e][j] == 1 && group[j[0=] 0) {
]               group[j] = m;
                ++groupS ze[m]|= 1 << (e[1] - 1);
                groupMax[m] = max(groupMax[m], groupSize[m]);
                dfs(j, m, graph, group, groupSize, groupMax);
            }
         
    }
};