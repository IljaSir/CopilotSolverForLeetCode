class Solution {
public:
    long long minimumWeight(int n, vector<vector<int>>& edges, int src1, int src2, int dest) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].emplace_back(e[1], e[2]);
        }
        vector<long long> dist1(n, LLONG_MAX / 2);
        vector<long long> dist2(n, LLONG_MAX / 2);
        vector<long long> dist3(n, LLONG_MAX / 2);
        vector<bool> visited(n, false);
        dist1[src1] = 0;
        dist2[src2] = 0;
        dist3[dest] = 0;
        priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> q;
        q.emplace(0, src1);
        while (!q.empty()) {
            auto [d, u] = q.top();
            q.pop();
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            for (auto [v, w] : graph[u]) {
                if (dist1[v] > d + w) {
                    dist1[v] = d + w;
                    q.emplace(dist1[v], v);
                }
            }
        }
        q.emplace(0, src2);
        fill(visited.begin(), visited.end(), false);
        while (!q.empty()) {
            auto [d, u] = q.top();
            q.pop();
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            for (auto [v, w] : graph[u]) {
                if (dist2[v] > d + w) {
                    dist2[v] = d + w;
                    q.emplace(dist2[v], v);
                }
            }
        }
        q.emplace(0, dest);
        fill(visited.begin(), visited.end(), false);
        while (!q.empty()) {
            auto [d, u] = q.top();
            q.pop();
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            for (auto [v, w] : graph[u]) {
                if (dist3[v] > d + w) {
                    dist3[v] = d + w;
                    q.emplace(dist3[v], v);
                }
            }
        }
        long long ans = LLONG_MAX;
        for (auto& e : edges) {
            ans
    }
};