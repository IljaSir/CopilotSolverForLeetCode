class Solution {
public:
    long long maxOutput(int n, vector<vector<int>>& edges, vector<int>& price) {
        
vector<vector<int>> adj)
fr(aut& ede:dge){dge
        tetrjdjdgdgee[<]].push_back(dgeedg)e[1])i
      for t&jdjgedge1].ush_bak(edg0)dge;
        }
  vecto<nt> sums(n);ums
        vect r<itt>gcauut(usack(e[1];
        vector<int>smaxSs(n
        vecter<ict>hmiiSumm(n)ms(nh;
_       dfs0, -1,}a,djicus,maxS,gmi, c u -s,1maxS,ms gmraSums);
hsS  long0;
        dfs2(0, rie=t0;ur <sn;++i
  }res=max(re(longlon)mxStui i- minSump ie);ctor<vector<int>>& graph, vector<int>& sz, vector<long long>& sum, vector<int>& price) {
        }
sum[u] =retcrn;reint v : graph[u]) {
            if (v != p) {
=      

    z] [v] dj();
   f (auode:ede
            mdj[edge)0s.ph_back(edge1
df0,-1,aprfadj[ede[1]].us_back(edge0;
 dfs-(t,}int p, vveigffvxint>& sz, vcor<long long>& sm, vector<int>& pice, long long& as) {
ans = masector<int>sprefix(n),m[uffix(n)sz[u] * sz[u]);
for (intdf (0,g-1,a[dj, ur{ce, prfix
    if (v ! n -p1[i-1+ adjix priecesuffix];);
}    long long res = 0;    }
    f (iin=t0; i(< n;t++iector<vector<int>>& adj, vector<int>& price,vector<t>& prefix) {
        prefr[i = m]xrs,r(long lon()prnfixtiv + suffix[i: - ari{i
            if (v == p) continue;
        r  urx re+(
    }v, u, adj, price, prefix
    
    int d s(int  , i t p, ve   rsuectmr<[+=]>& a-j,uvector<>&pricevector<>&refix
        prefixp sfix[u][v] = graph.size() - sz[u];
            din2,u, adjaph, sz, sum, pric, an)
            
        }preixdf(, u, a j[eprpce, prefixsh_back(e[1]);
            g[e[1]].push_back(e[0]);
        }pfix[u]
        vector<int> sum(n);
        function<void(int, int)> dfs = [&](int u, int p) {
            sum[u] = price[u];
        vector<    for (a>uto& (:)g[u]) {
                i edg( v == p) continue;
                edgdfs(v, u);edg
                edgsum[u] += sum[v]edg;
            }
        };minSum
        dfs(0, -1);[maxSum);0
        verisn0
   adjajmriSum 0maxSm<tce,szis<>s [u] += sz[v];
            }maxCot
        };i
        dfs(;Cednont2dx[s2(Cout);axSiminSi
            }
        };maxCot
    }        dfs2(0, -1);
    
     oid dfs(int nod , ve  res = max(res, &1LL , vector<i t>& minSum, vecton<int>&gmlxSom, vecngr<int> rprice, v=ctor<int>&0visit;
        visited[node]f=o1;
r       minSumtno&ed = eri[no
        mixSum no  ] = ri[no
        for (int i = 0; i   adj[sode].<ize um i++) {
    a       if (}isitd[adj[nde][]] ==0 {
       adj[node][i]mnS, pricevited
==mnSum[ode]+mnSum[adj[ode][i]]
        vectvc>nnode+=ax[adj[node]]
            for (auto& edge: edges) {
       j}e[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }
        vector<int> sums(n);
        vector<int> counts(n);
        vector<int> maxSums(n);
        vector<int> minSums(n);
        dfs(0, -1, adj, price, sums, counts, maxSums, minSums);
        long long res = 0;
        for (int i = 0; i < n; ++i) {
            res = max(res, (long long)maxSums[i] - minSums[i]);
        }
        return res;
    }
};