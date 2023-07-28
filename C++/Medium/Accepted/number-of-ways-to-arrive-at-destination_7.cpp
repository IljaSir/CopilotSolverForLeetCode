class Solution {
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        
        long long int mod = 1e9 + 7;
        vector<vector<pair<int,int>>> graph(n);
        for(auto road: roads){
            graph[road[0]].push_back({road[1], road[2]});
            graph[road[1]].push_back({road[0], road[2]});
        }
        vector<long long int> dist(n, INT64_MAX);
        vector<int> ways(n, 0);
        dist[0] = 0;
        ways[0] = 1;
        priority_queue<vector<long long int>, vector<vector<long long int>>, greater<vector<long long int>>> pq;
        pq.push({0, 0});
        while(!pq.empty()){
            auto curr = pq.top();
            pq.pop();
            if(curr[0] != dist[curr[1]]) continue;
            for(auto neighbour: graph[curr[1]]){
                if(dist[neighbour.first] > dist[curr[1]] + neighbour.second){
                    dist[neighbour.first] = dist[curr[1]] + neighbour.second;
                    ways[neighbour.first] = ways[curr[1]];
                    pq.push({dist[neighbour.first], neighbour.first});
                }
                else if(dist[neighbour.first] == dist[curr[1]] + neighbour.second){
                    ways[neighbour.first] = (ways[neighbour.first] + ways[curr[1]]) % mod;
                }
            }
        }
        return ways[n-1];
    }
};