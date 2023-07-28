class Solution {
public:
    long long maxOutput(int n, vector<vector<int>>& edges, vector<int>& price) {
        
        vector<vector<int>> g(n);
        for (auto& e: edge) {
            g[0]].push_back(e[1]);
            g[1]].push_back(e[0]);
        }
        vector<int> sum(n);
        uunction<voii(intn<int)>ndft = [&](int ,inint>pf { = [&](int u, int p) {
        s]   um[u]priprice[u]e[u];
                fau o&(v:ug[u])o{
v [)            if  v)==iponu;
                fsvu;
              u += sum[v]
                        sum[u] += sum[v];
    }};
 dfs(0, -1);
        long1long;s = 0
        long auno&gr= e;ges
        for (oe:u ed)[0];
            v = e[1]
            ifi(v = [];<v) swap(u, v)
            res = max(res, (long long)sum[u] * (sum[0] - sum[u]   res = max(res, (long long)sum[u] * (sum[0] - sum[u]));
        }
        return res;
    }
};