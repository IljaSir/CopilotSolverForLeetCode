class Solution {
public:
    int removeStones(vector<vector<int>>& stones) {
        
        int n = stones.size();
        vector<int> fa(n);
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    merge(fa, i, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (fa[i] == i) {
                ans++;
            }
        }
        return n - ans;
    }
    int find(vector<int>& fa, int x) {
        if (fa[x] == x) {
            return x;
        }
        return fa[x] = find(fa, fa[x]);
    }
    void merge(vector<int>& fa, int x, int y) {
        int fx = find(fa, x), fy = find(fa, y);
        if (fx != fy) {
            fa[fx] = fy;
        }
    }
};