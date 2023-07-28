class Solution {
public:
    int magnificentSets(int n, vector<vector<int>>& edges) {
        
        vector<int> v(n+1, 0);
        vector<vector<int>> g(n+1);
        for(auto& e: edges){
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> s;
        for(int i=1; i<=n; i++)
            if(!v[i]){
                s.clear();
                dfs(i, v, g, s);
                for(auto& x: s)
                    v[x] = s.size();
            }
        int ans = 0;
        for(int i=1; i<=n; i++)
            ans = max(ans, v[i]);
        return ans;
    }
};