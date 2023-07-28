class Solution {
public:
    int removeStones(vector<vector<int>>& stones) {
        
        int n = stones.size();
        vector<int> parent(n);
        iota(parent.begin(), parent.end(), 0);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    int pi = find(parent, i);
                    int pj = find(parent, j);
                    if (pi != pj) {
                        parent[pj] = pi;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i == parent[i]) {
                ++ans;
            }
        }
        return n - ans;
    }
};