class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        
        vector<vector<pair<int, double>>> graph(n);
        for (int i = 0; i < edges.size(); ++i) {
            graph[edges[i][0]].push_back({edges[i][1], succProb[i]});
            graph[edges[i][1]].push_back({edges[i][0], succProb[i]});
        }
        priority_queue<pair<double, int>> pq;
        pq.push({1, start});
        vector<double> probs(n, 0);
        probs[start] = 1;
        while (!pq.empty()) {
            auto [prob, node] = pq.top();
            pq.pop();
            if (node == end) {
                return prob;
            }
            for (auto& [next, p] : graph[node]) {
                if (prob * p > probs[next]) {
                    probs[next] = prob * p;
                    pq.push({probs[next], next});
                }
            }
        }
        return 0;
    }
};