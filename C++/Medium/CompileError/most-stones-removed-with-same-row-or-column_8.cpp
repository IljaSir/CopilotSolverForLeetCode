class Solution {
public:
    int removeStones(vector<vector<int>>& stones) {
        
        int n = stones.size();
        if (n <= 1) return 0;
        vector<int> p(n);
        iota(p.begin(), p.end(), 0);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    p[find(p, j)] = find(p, i);
                }
            }
        }
        unordered_set<int> s;
        for (int i = 0; i < n; ++i) {
            s.insert(find(p, i));
        }
        return n - s.size();
    }
};