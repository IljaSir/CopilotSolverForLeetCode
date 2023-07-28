class Solution {
public:
    int countHighestScoreNodes(vector<int>& parents) {
        
        int n = parents.size();
        vector<vector<int>> children(n);
        for (int i = 1; i < n; ++i) {
            children[parents[i]].push_back(i);
        }
        vector<int> sz(n, 1);
        vector<int> best(n, 0);
        vector<int> bestCount(n, 1);
        for (int i = n - 1; i > 0; --i) {
            int p = parents[i];
            sz[p] += sz[i];
            int s = sz[i] * best[i] + best[p];
            if (s > best[p]) {
                best[p] = s;
                bestCount[p] = bestCount[i];
            } else if (s == best[p]) {
                bestCount[p] += bestCount[i];
            }
        }
        return bestCount[0];
    }
};