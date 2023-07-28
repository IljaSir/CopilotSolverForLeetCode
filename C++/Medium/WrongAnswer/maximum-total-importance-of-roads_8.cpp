class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        
        vector<vector<int>> graph(n);
        for(auto & road : roads){
            graph[road[0]].push_back(road[1]);
            graph[road[1]].push_back(road[0]);
        }
        vector<int> visited(n, 0);
        long long ans = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                vector<int> cnt(n, 0);
                dfs(graph, visited, cnt, i);
                long long sum = 0;
                for(int j = 0; j < n; j++){
                    sum += cnt[j] * (cnt[j] - 1) / 2;
                }
                ans = max(ans, sum);
            }
        }
        return ans;
    }
    void dfs(vector<vector<int>> & graph, vector<int> & visited, vector<int> & cnt, int i){
        visited[i] = 1;
        cnt[i] = 1;
        for(auto & j : graph[i]){
            if(visited[j] == 0){
                dfs(graph, visited, cnt, j);
                cnt[i] += cnt[j];
            }
        }
    }
};