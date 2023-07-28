class Solution {
public:
    int mostProfitablePath(vector<vector<int>>& edges, int bob, vector<int>& amount) {
        
        int n = amount.size();
        vector<vector<int>> adj(n);
        for(auto e : edges){
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> visited(n, 0);
        vector<int> dp(n, 0);
        vector<int> path;
        dfs(0, adj, visited, dp, path, amount, bob);
        return dp[0];
    }
    void dfs(int node, vector<vector<int>>& adj, vector<int>& visited, vector<int>& dp, vector<int>& path, vector<int>& amount, int bob){
        visited[node] = 1;
        path.push_back(node);
        if(node == bob){
            int n = path.size();
            int i = 0, j = n - 1;
            while(i < j){
                int temp = path[i];
                path[i] = path[j];
                path[j] = temp;
                i++;
                j--;
            }
        }
        for(auto v : adj[node]){
            if(!visited[v]){
                dfs(v, adj, visited, dp, path, amount, bob);
            }
        }
        if(node == bob){
            int n = path.size();
            int i = 0, j = n - 1;
            while(i < j){
                int temp = path[i];
                path[i] = path[j];
                path[j] = temp;
                i++;
                j--;
            }
        }
        int max_val = INT_MIN;
        for(auto v : adj[node]){
            if(v != 0){
                max_val = max(max_val, dp[v]);
            }
        }
        if(amount[node] < 0){
            dp[node] = -amount[node] + max_val;
        }else{
            dp[node] = amount[node] + max_val;
        }
        path.pop_back();
    }
};