class Solution {
public:
    int rootCount(vector<vector<int>>& edges, vector<vector<int>>& guesses, int k) {
        
        int n = edges.size();
        vector<vector<int>> graph(n+1);
        for(int i=0;i<n;i++){
            graph[edges[i][0]].push_back(edges[i][1]);
            graph[edges[i][1]].push_back(edges[i][0]);
        }
        vector<int> degree(n+1);
        for(int i=0;i<n;i++){
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        vector<int> leaves;
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                leaves.push_back(i);
            }
        }
        int res = 0;
        for(auto leaf : leaves){
            vector<int> parent(n+1);
            parent[leaf] = -1;
            queue<int> q;
            q.push(leaf);
            while(!q.empty()){
                int cur = q.front();
                q.pop();
                for(auto next : graph[cur]){
                    if(parent[next]==0){
                        parent[next] = cur;
                        q.push(next);
                    }
                }
            }
            int count = 0;
            for(auto guess : guesses){
                if(parent[guess[0]]==guess[1]){
                    count++;
                }
            }
            if(count>=k){
                res++;
            }
        }
        return res;
    }
};