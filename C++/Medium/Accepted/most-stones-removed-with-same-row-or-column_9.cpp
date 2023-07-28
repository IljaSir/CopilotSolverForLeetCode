class Solution {
public:
    int removeStones(vector<vector<int>>& stones) {
        
        int n = stones.size();
        int res = 0;
        vector<int> f(n);
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    f[find(i, f)] = find(j, f);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (f[i] == i) {
                res++;
            }
        }
        return n - res;
    }
    int find(int x, vector<int>& f) {
        if (f[x] != x) {
            f[x] = find(f[x], f);
        }
        return f[x];
    }
};