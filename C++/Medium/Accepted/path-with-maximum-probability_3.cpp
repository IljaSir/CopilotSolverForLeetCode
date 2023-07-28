class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        
        vector<vector<pair<int, double>>> graph(n);
        for (int i = 0; i < edges.size(); i++) {
            graph[edges[i][0]].push_back({edges[i][1], succProb[i]});
            graph[edges[i][1]].push_back({edges[i][0], succProb[i]});
        }
        priority_queue<pair<double, int>> pq;
        pq.push({1.0, start});
        vector<double> prob(n, 0.0);
        prob[start] = 1.0;
        while (!pq.empty()) {
            auto [curProb, curNode] = pq.top();
            pq.pop();
            if (curNode == end) {
                return curProb;
            }
            for (auto [nextNode, nextProb]: graph[curNode]) {
                if (curProb * nextProb > prob[nextNode]) {
                    prob[nextNode] = curProb * nextProb;
                    pq.push({prob[nextNode], nextNode});
                }
            }
        }
        return 0.0;
    }
};