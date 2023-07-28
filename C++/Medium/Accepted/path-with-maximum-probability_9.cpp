class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        
        vector<vector<pair<int,double>>> graph(n);
        for(int i = 0; i < edges.size(); i++) {
            graph[edges[i][0]].push_back({edges[i][1], succProb[i]});
            graph[edges[i][1]].push_back({edges[i][0], succProb[i]});
        }
        vector<double> prob(n, 0.0);
        prob[start] = 1.0;
        priority_queue<pair<double, int>> pq;
        pq.push({1.0, start});
        while(!pq.empty()) {
            auto p = pq.top();
            pq.pop();
            int node = p.second;
            double probab = p.first;
            if(node == end) return probab;
            if(probab < prob[node]) continue;
            for(auto& e : graph[node]) {
                if(prob[node] * e.second > prob[e.first]) {
                    prob[e.first] = prob[node] * e.second;
                    pq.push({prob[e.first], e.first});
                }
            }
        }
        return 0.0;
    }
};