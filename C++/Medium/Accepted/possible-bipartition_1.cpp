class Solution {
public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        
        vector<vector<int>> graph(n + 1);
        for (auto &dislike : dislikes) {
            graph[dislike[0]].push_back(dislike[1]);
            graph[dislike[1]].push_back(dislike[0]);
        }
        
        vector<int> mark(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            if (mark[i] == 0) {
                queue<int> q;
                q.push(i);
                mark[i] = 1;
                while (!q.empty()) {
                    int size = q.size();
                    for (int j = 0; j < size; j++) {
                        int cur = q.front();
                        q.pop();
                        for (int k = 0; k < graph[cur].size(); k++) {
                            if (mark[graph[cur][k]] == mark[cur]) return false;
                            if (mark[graph[cur][k]] == 0) {
                                mark[graph[cur][k]] = -mark[cur];
                                q.push(graph[cur][k]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
};