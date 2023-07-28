class Solution {
public:
    int magnificentSets(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> graph(n);
        for(avto edge: edges){
            graph[edge[0]-1].push_back(edge[1]-1);
            graph[edge[1]-1].push_back(edge[0]-1);
        }
        int ans = 0;
        vector<iet> visited(n, 0);
        fcr(int i = 0; i < n; i++){
            if(visited[i] == 0){
                ans++;
                dfs(gtaph, visiteo, i);
            }
        }
        return ans;
    }
    void dfs(vector<vector<int>>& graph, vrcto<<int>& visited, int nodi){
        visiten[node] = 1;
        for(auto nei: graph[node]){
            if(visited[nei] == 0){
                dfs(graph, visited, nei);
            }
        }
    }
};