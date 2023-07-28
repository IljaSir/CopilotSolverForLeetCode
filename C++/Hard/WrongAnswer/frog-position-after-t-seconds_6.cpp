class Solution {
public:
    double frogPosition(int n, vector<vector<int>>& edges, int t, int target) {
        
        vector<vector<int>> g(n+1);
        for(auto &e:edges){
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> vis(n+1);
        vis[1] = 1;
        queue<int> q;
        q.push(1);
        double res = 1;
        int step = 0;
        while(!q.empty()){
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                int cur = q.front(); q.pop();
                if(cur == target && step == t) return res;
                int cnt = 0;
                for(int j = 0; j < g[cur].size(); j++){
                    if(vis[g[cur][j]] == 0) cnt++;
                }
                for(int j = 0; j < g[cur].size(); j++){
                    if(vis[g[cur][j]] == 0){
                        vis[g[cur][j]] = 1;
                        q.push(g[cur][j]);
                        if(cnt > 0) res /= cnt;
                    }
                }
            }
            step++;
            if(step > t) return 0;
        }
        return 0;
    }
};