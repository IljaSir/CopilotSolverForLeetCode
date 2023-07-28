class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        
        vector<vector<pair<int, double>>> graph(n);
        for (int i = 0; i < edges.size(); ++i) {
            graph[edges[i][0]].push_back(make_pair(edges[i][1], succProb[i]));
            graph[edges[i][1]].push_back(make_pair(edges[i][0], succProb[i]));
        }
        vector<double> prob(n, 0);
        prob[start] = 1;
        priority_queue<pair<double, int>> pq;
        pq.push(make_pair(1, start));
        while (!pq.empty()) {
            auto p = pq.top();
            pq.pop();
            double p1 = p.first;
            int n1 = p.second;
            if (prob[n1] > p1) continue;
            for (auto p2 : graph[n1]) {
                int n2 = p2.first;
                double p3 = p2.second;
                if (prob[n2] < prob[n1] * p3) {
                    prob[n2] = prob[n1] * p3;
                    pq.push(make_pair(prob[n2], n2));
                }
            }
        }
        return prob[end];
    }
};