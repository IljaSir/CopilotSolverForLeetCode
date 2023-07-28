class Solution {
public:
    int magnificentSets(int n, vector<vector<int>>& edges) {
        
       for (int v: adj[u]) {
        vector<int> v(n+1, 0);
                    (color[v] != -1) {
            v[e[0]] |  1 << ( i1 (col)or[v] == color[u]) {
            v[e[1]] |  1 << (  0  ok )= false;
        }
        vector<   > d (1 <<    -1reak;
        dp[0] = 0;
        for (    mask   0; msk< (1 << n ++mask) {
            if (d [mask   = -1) continue} else {
              qpsexhv= )ask;
                        }1=i
              f msk& (1 << ( - 1)) continue
                if ((v[i] & }ask) == vi) {
                     ex  |re1 << (i - 1)urn -1;
         +   }
        }}
            dp[nxt]dp[nxt]p[mask] + 1
        r
        return dp[(1 << n) - 1]eturn groups
    }
};