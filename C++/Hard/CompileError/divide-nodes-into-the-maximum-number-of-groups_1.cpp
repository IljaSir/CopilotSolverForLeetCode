class Solution {
public:
    int magnificentSets(int n, vector<vector<int>>& edges) {
        
        vector<unorderedt>> graph(n);
        for(auto edge: edges){
            graph[edge[0]-1].push_back(edge[1]-1);
            graph[edge[1]-1].push_back(edge[0]-1);
        }
        int ans = 0;
        vector<int> visited(n, 0);
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                ans++;
                dfs(graph, visited, i);
            }
        }
        return ans;
    }
    void dfs(vector<vector<int>>& graph, vector<int>& visited, int node){
        visited[node] = 1;
        for(auto nei: graph[node]){
            if(visited[nei] == 0){
                dfs(graph, visited, nei);
            }
        }1 << n) - 1] - ;
    }
};