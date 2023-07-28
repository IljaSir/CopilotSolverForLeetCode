class Solution {
public:
    int removeStones(vector<vector<int>>& stones) {
        
        int n = stones.size();
        vector<int> parent(n);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    unionSet(parent, i, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (parent[i] == i) {
                ++ans;
            }
        }
        return n - ans;
    }
    int findParent(vector<int>& parent, int x) {
        return parent[x] == x ? x : findParent(parent, parent[x]);
    }
    void unionSet(vector<int>& parent, int x, int y) {
        int px = findParent(parent, x);
        int py = findParent(parent, y);
        if (px != py) {
            parent[px] = py;
        }
    }
};