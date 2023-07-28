class Solution {
public:
    int minimumHammingDistance(vector<int>& source, vector<int>& target, vector<vector<int>>& allowedSwaps) {
        
        int n = source.size();
        vector<int> parent(n);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        for (const auto& swap : allowedSwaps) {
            int x = find(parent, swap[0]);
            int y = find(parent, swap[1]);
            if (x != y) {
                parent[x] = y;
            }
        }
        unordered_map<int, unordered_map<int, int>> count;
        for (int i = 0; i < n; ++i) {
            count[find(parent, i)][source[i]]++;
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (--count[find(parent, i)][target[i]] < 0) {
                res++;
            }
        }
        return res;
    }
};