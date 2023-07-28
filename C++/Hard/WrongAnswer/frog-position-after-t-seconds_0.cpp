class Solution {
public:
    double frogPosition(int n, vector<vector<int>>& edges, int t, int target) {
        
        vector<vector<int>> adj(n + 1);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<double> prob(n + 1, 0);
        prob[1] = 1.0;
        queue<int> q;
        q.push(1);
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.front();
                q.pop();
                if (cur == target && step == t) {
                    return prob[cur];
                }
                int count = 0;
                for (int next : adj[cur]) {
                    if (prob[next] == 0) {
                        count++;
                    }
                }
                for (int next : adj[cur]) {
                    if (prob[next] == 0) {
                        prob[next] = prob[cur] / count;
                        q.push(next);
                    }
                }
            }
            step++;
        }
        return 0;
    }
};