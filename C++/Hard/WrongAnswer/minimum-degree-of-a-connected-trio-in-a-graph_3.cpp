class Solution {
public:
    int minTrioDegree(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> graph(n+1);
        vector<int> degree(n+1);
        for(auto& edge: edges){
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        int ans = INT_MAX;
        for(int i = 1; i < n; i++){
            for(int j = i+1; j <= n; j++){
                int cnt = 0;
                for(int k = 1; k <= n; k++){
                    if(k == i || k == j) continue;
                    if(binary_search(graph[i].begin(), graph[i].end(), k) && binary_search(graph[j].begin(), graph[j].end(), k)){
                        cnt++;
                    }
                }
                if(cnt > 0){
                    ans = min(ans, degree[i] + degree[j] + cnt - 6);
                }
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};