class Solution {
public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        
        vector<int> group(n + 1, 0);
        vector<vector<int>> graph(n + 1);
        for (auto& dislike : dislikes) {
            graph[dislike[0]].push_back(dislike[1]);
            graph[dislike[1]].push_back(dislike[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (group[i] == 0 && !dfs(graph, group, 1, i)) {
                return false;
            }
        }
        return true;
    }
    
    bool dfs(vector<vector<int>>& graph, vector<int>& group, int g, int node) {
        if (group[node] != 0) {
            return group[node] == g;
        }
        group[node] = g;
        for (auto& next : graph[node]) {
            if (!dfs(graph, group, -g, next)) {
                return false;
            }
        }
        return true;
    }
};