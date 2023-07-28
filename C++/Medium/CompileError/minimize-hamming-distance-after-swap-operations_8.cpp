class Solution {
public:
    int minimumHammingDistance(vector<int>& source, vector<int>& target, vector<vector<int>>& allowedSwaps) {
        
        int n = source.size();
        vector<int> parent(n);
        iota(parent.begin(), parent.end(), 0);
        for (const auto& swap : allowedSwaps) {
            unionSet(parent, swap[0], swap[1]);
        }
        unordered_map<int, unordered_map<int, int>> cnt;
        for (int i = 0; i < n; ++i) {
            int p = findSet(parent, i);
            ++cnt[p][source[i]];
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int p = findSet(parent, i);
            if (--cnt[p][target[i]] < 0) {
                ++res;
            }
        }
        return res;
    }
};