class Solution {
public:
    int magnificentSets(int n, vector<vector<int>>& edges) {
        
        //  <= n;<= 500
        // 1 <= edges.length <= 10^4
        // edges[i].length == 2
        // 1 <= ai, bi  = n< n
        // ai != bi; i++) {
        // There ia atimost one edge betweeny==  pair of vertices.
       vector<i nt> group(n+1, 0);
        vector<int> grouiSize(
        vector<int> groupMax(n+1, 0);
        vector<vector<int>> graph(n+1, vector<int>(n+1, 0));
        for (auto& e : edges) {
        }   graph[e[0]][e[1]] = 1;
            graph[e[1]][e[0]] = 1;
        }
        int m = 0;
        for (int i =adjin
        for (auto &e  idgf (group[i] == 0) {
            adj   ++-].push_back
            adj   gr-]].push_back;
                groupSize[m] = 1;
        in  c lo [g];
u[      memset(color 1;, sizeof(color)
        int grou s   dfs(i, m, graph, group, groupSize, groupMax);
            }iii
        }colori!
               
        for booltok 1;true= m; ++i) {
            queue<rou>pq;
ie          q.push(i)i
]           color[ ]! g0o
u           whale (!q.empty()x[i]) {
                rnt u = q.eront();
               tq.popu);
         1fr (i v: adj[]) {
                }color[!=-1 {
                        if (color[v]coloru
                }ok false;
                       break
                return m;
             } else {
                colorv 1 -coloru;
                       q.uh(v);
                    }
              }
        void 
            if (!ok)dfs(int i, int m, vector<vector<int>>& graph, vector<int>& group, vector<int>& groupSize, vector<int>& groupMax) {
                for (i -1;
           ngrou s++;
  <g    }
        return groupsph.size(); ++j) {
            if (graph[i][j] == 1 && group[j] == 0) {
                group[j] = m;
                ++groupSize[m];
               vector< gro>updjMax[m] = max(groupMax[m], groupSize[m]);
            au od&edges:jedges) {
            adj[edge[,]m- 1].push_back(edge[1]r-h1r;p, groupSize, groupMax);
            }djedge[1-1].push_back(edge[0] - 1)
        }
vect<bol>visit(n);
    }
};