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
                    parent[find(parent, i)] = find(parent, j);
                }
            }
        }
        unordered_set<int> seen;
        for (int i = 0; i < n; ++i) {
            seen.insert(find(parent, i));
        }
        return n - seen.size();
    }
    int find(vector<int>& parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
};