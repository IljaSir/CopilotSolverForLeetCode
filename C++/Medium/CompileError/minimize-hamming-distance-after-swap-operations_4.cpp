class Solution {
public:
    int minimumHammingDistance(vector<int>& source, vector<int>& target, vector<vector<int>>& allowedSwaps) {
        
        int n = source.size();
        vector<int> parent(n, 0);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        for (auto& swap : allowedSwaps) {
            int x = findParent(parent, swap[0]);
            int y = findParent(parent, swap[1]);
            parent[x] = y;
        }
        unordered_map<int, unordered_map<int, int>> m;
        for (int i = 0; i < n; ++i) {
            int p = findParent(parent, i);
            ++m[p][source[i]];
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int p = findParent(parent, i);
            if (m[p][target[i]] > 0) {
                --m[p][target[i]];
            } else {
                ++res;
            }
        }
        return res;
    }
};