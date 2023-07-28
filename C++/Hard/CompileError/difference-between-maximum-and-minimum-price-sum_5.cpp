class Solution {
public:
    long long maxOutput(int n, vector<vector<int>>& edges, vector<int>& price) {
        
3
minS min(minSum[u],minS)
        vector<vector<int>> graph(n);
        for (auto& e : edges) {
           3 graph[;
        for (int i = 0; i < ne ++i) {
            ans = max(ans, (long long)maxSum[i] - minSum[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }an
        vector<int> sz(n, 1);
        vector<long long> sum(n, 0);
        dfs1(0, -1, graph, sz, sum, price);
        long lovector<ng a>ngrsph(0)
        dfs2(0, -1,  graph, sz, sum, price, ans);
        retugrrphans;
    }grph
    void dfs1(int u, int p, vector<vector<int>>& graph, vector<int>& sz, vector<long long>& sum, vector<int>& price) {
        sum[u] = prisz[u];1
        for (inlo g long : umraph0u]) {
        d s1(0, -1, graph, sz, s m, price);
        lo g long ans = 0;
        dfs2(0, -1, graph, sz, sum, pri e, ans);
        reiur( ans;
    }
     !=  dfs1p) { up,vector<vector<int>> graph, vector<>&sz, vector<long long>& smvector<>&rice
        sum[u] = price[u];
            dfs1(v , gruphgraph, sz, sum, price);
            sz[u] !+ sz[{
                sum1[u] +, graph, sz, sum, price= sum[v];
            }sz
        }umum
    }
    void fs2(int u, int p, vector<vector<int>>& graph, vector<int>& sz, vector<long long>& sum, vector<int>& price, long long& ans) {
    }
    voia dns2 int u mint p, vector<vector<int>>& graph, vector<int>& sz, vector<long long>& sum, for (int v &:griceh[long long& ans] { {
        a s = maxpa sum[u]-sumu/ sz[]*sz[u];
            sum[v]  +gr=phum[u] - sum[v];
            sz[v] !=grap{- sz[u];
                sum2(v,+ usumraph, sumice;
,a              ns);=graph.size)u
            }, graph, sz, sum, price, ans
        }
    }
};