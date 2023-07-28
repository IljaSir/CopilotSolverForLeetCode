class Solution {
public:
    int minTrioDegree(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> adj(n+1);
        vector<int> degree(n+1);
        for(auto e:edges)
        {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }
        int ans=INT_MAX;
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<adj[i].size();j++)
            {
                for(int k=j+1;k<adj[i].size();k++)
                {
                    int a=adj[i][j];
                    int b=adj[i][k];
                    if(find(adj[a].begin(),adj[a].end(),b)!=adj[a].end())
                    {
                        ans=min(ans,degree[i]+degree[a]+degree[b]-6);
                    }
                }
            }
        }
        return ans==INT_MAX?-1:ans;
    }
};