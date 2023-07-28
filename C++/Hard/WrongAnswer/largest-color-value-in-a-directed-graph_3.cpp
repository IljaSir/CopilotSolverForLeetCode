class Solution {
public:
    int largestPathValue(string colors, vector<vector<int>>& edges) {
        
        int n = colors.size();
        vector<vector<int>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
        }
        vector<int> inDegree(n);
        for (auto& e : edges) {
            inDegree[e[1]]++;
        }
        vector<int> colorCount(n, 0);
        vector<vector<int>> colorCountInPath(n, vector<int>(26, 0));
        int maxColorCount = 0;
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.push(i);
                colorCountInPath[i][colors[i] - 'a']++;
                colorCount[i] = 1;
            }
        }
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            maxColorCount = max(maxColorCount, colorCount[u]);
            for (auto& v : graph[u]) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.push(v);
                }
                for (int i = 0; i < 26; i++) {
                    colorCountInPath[v][i] = max(colorCountInPath[v][i], colorCountInPath[u][i]);
                }
                if (colors[u] == colors[v]) {
                    colorCount[v] = max(colorCount[v], colorCount[u] + 1);
                } else {
                    colorCount[v] = max(colorCount[v], colorCountInPath[u][colors[v] - 'a'] + 1);
                }
                colorCountInPath[v][colors[u] - 'a'] = max(colorCountInPath[v][colors[u] - 'a'], colorCount[u] + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (inDegree[i] != 0) {
                return -1;
            }
        }
        return maxColorCount;
    }
};