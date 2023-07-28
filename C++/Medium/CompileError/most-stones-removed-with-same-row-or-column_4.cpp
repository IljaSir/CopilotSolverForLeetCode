class Solution {
public:
    int removeStones(vector<vector<int>>& stones) {
        
        int n = stones.size();
        vector<int> parent(n);
        iota(parent.begin(), parent.end(), 0);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    unionSet(parent, i, j);
                }
            }
        }
        unordered_set<int> roots;
        for (int i = 0; i < n; ++i) {
            roots.insert(find(parent, i));
        }
        return n - roots.size();
    }
};