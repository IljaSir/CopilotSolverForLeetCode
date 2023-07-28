class Solution {
public:
    int largestPathValue(string colors, vector<vector<int>>& edges) {
        
        vector<int> in(colors.size(), 0);
        vector<vector<int>> out(colors.size(), vector<int>());
        vector<vector<int>> colorsCount(colors.size(), vector<int>(26, 0));
        for (auto edge : edges) {
            out[edge[0]].push_back(edge[1]);
            in[edge[1]]++;
        }
        queue<int> q;
        for (int i = 0; i < colors.size(); ++i) {
            if (in[i] == 0) {
                q.push(i);
                colorsCount[i][colors[i] - 'a'] = 1;
            }
        }
        int res = 0;
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            for (int next : out[node]) {
                for (int i = 0; i < 26; ++i) {
                    colorsCount[next][i] = max(colorsCount[next][i], colorsCount[node][i]);
                }
                colorsCount[next][colors[next] - 'a']++;
                in[next]--;
                if (in[next] == 0) {
                    q.push(next);
                }
            }
        }
        for (int i = 0; i < colors.size(); ++i) {
            if (in[i] != 0) {
                return -1;
            }
            for (int j = 0; j < 26; ++j) {
                res = max(res, colorsCount[i][j]);
            }
        }
        return res;
    }
};