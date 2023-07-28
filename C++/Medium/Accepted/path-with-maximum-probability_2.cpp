class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        
        vector<vector<pair<int, double>>> graph(n);
        for (int i = 0; i < edges.size(); i++) {
            graph[edges[i][0]].push_back({edges[i][1], succProb[i]});
            graph[edges[i][1]].push_back({edges[i][0], succProb[i]});
        }
        priority_queue<pair<double, int>> pq;
        vector<double> prob(n, 0);
        prob[start] = 1;
        pq.push({1, start});
        while (!pq.empty()) {
            auto p = pq.top();
            pq.pop();
            if (p.second == end) return p.first;
            if (prob[p.second] > p.first) continue;
            for (auto c: graph[p.second]) {
                if (prob[c.first] < p.first * c.second) {
                    prob[c.first] = p.first * c.second;
                    pq.push({prob[c.first], c.first});
                }
            }
        }
        return 0;
    }
};