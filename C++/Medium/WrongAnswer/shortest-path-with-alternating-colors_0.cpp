class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
        
        vector<vector<int>> red(n), blue(n);
        for (auto& e: redEdges) red[e[0]].push_back(e[1]);
        for (auto& e: blueEdges) blue[e[0]].push_back(e[1]);
        vector<int> ans(n, INT_MAX);
        queue<pair<int, int>> q;
        q.push({0, 0}); q.push({0, 1});
        ans[0] = 0;
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            ++step;
            while (size--) {
                auto [i, color] = q.front(); q.pop();
                if (color == 0) {
                    for (auto j: red[i]) {
                        if (step < ans[j]) {
                            q.push({j, 1});
                            ans[j] = step;
                        }
                    }
                } else {
                    for (auto j: blue[i]) {
                        if (step < ans[j]) {
                            q.push({j, 0});
                            ans[j] = step;
                        }
                    }
                }
            }
        }
        for (auto& a: ans) {
            if (a == INT_MAX) a = -1;
        }
        return ans;
    }
};