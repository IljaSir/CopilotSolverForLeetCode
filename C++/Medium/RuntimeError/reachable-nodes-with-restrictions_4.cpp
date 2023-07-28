class Solution {
public:
    int reachableNodes(int n, vector<vector<int>>& edges, vector<int>& restricted) {
        
        vector<vector<pair<int,int>>> graph(n);
        for(auto& edge: edges) {
            graph[edge[0]].push_back({edge[1], edge[2]});
            graph[edge[1]].push_back({edge[0], edge[2]});
        }
        unordered_set<int> restrict(restricted.begin(), restricted.end());
        unordered_map<int, int> dist;
        dist[0] = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, 0});
        while(!pq.empty()) {
            auto [d, node] = pq.top();
            pq.pop();
            if(dist.find(node) != dist.end() && dist[node] < d) continue;
            for(auto [next, weight]: graph[node]) {
                if(dist.find(next) == dist.end() || dist[next] > d + weight + 1) {
                    dist[next] = d + weight + 1;
                    pq.push({dist[next], next});
                }
            }
        }
        int ans = dist.size();
        for(auto& edge: edges) {
            int d1 = dist.find(edge[0]) == dist.end() ? 0 : dist[edge[0]];
            int d2 = dist.find(edge[1]) == dist.end() ? 0 : dist[edge[1]];
            ans += min(d1 + d2, edge[2]);
            if(restrict.find(edge[0]) != restrict.end() && restrict.find(edge[1]) != restrict.end()) {
                if(d1 > edge[2]) ans -= d1 - edge[2];
                if(d2 > edge[2]) ans -= d2 - edge[2];
            }
        }
        return ans;
    }
};