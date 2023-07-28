class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        
        vector<vector<pair<int, double>>> adj(n);
        for (int i = 0; i < edges.size(); ++i) {
            adj[edges[i][0]].push_back(make_pair(edges[i][1], succProb[i]));
            adj[edges[i][1]].push_back(make_pair(edges[i][0], succProb[i]));
        }
        vector<double> prob(n, 0.0);
        prob[start] = 1.0;
        priority_queue<pair<double, int>> q;
        q.push(make_pair(1.0, start));
        while (!q.empty()) {
            auto p = q.top();
            q.pop();
            int u = p.second;
            double w = p.first;
            if (u == end) {
                return prob[u];
            }
            if (prob[u] > w) {
                continue;
            }
            for (auto& p : adj[u]) {
                int v = p.first;
                double w2 = p.second;
                if (prob[v] < prob[u] * w2) {
                    prob[v] = prob[u] * w2;
                    q.push(make_pair(prob[v], v));
                }
            }
        }
        return 0.0;
    }
};