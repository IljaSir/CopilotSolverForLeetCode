class Solution {
public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        
        vector<vector<int>> graph(n + 1, vector<int>());
        for (auto& dislike : dislikes) {
            graph[dislike[0]].push_back(dislike[1]);
            graph[dislike[1]].push_back(dislike[0]);
        }
        vector<int> color(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            if (color[i] != 0) continue;
            color[i] = 1;
            queue<int> q;
            q.push(i);
            while (!q.empty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int node = q.front();
                    q.pop();
                    for (auto& neighbor : graph[node]) {
                        if (color[neighbor] == color[node]) return false;
                        if (color[neighbor] != 0) continue;
                        color[neighbor] = -color[node];
                        q.push(neighbor);
                    }
                }
            }
        }
        return true;
    }
};