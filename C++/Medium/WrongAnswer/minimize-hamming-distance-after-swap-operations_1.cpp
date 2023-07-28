class Solution {
public:
    int minimumHammingDistance(vector<int>& source, vector<int>& target, vector<vector<int>>& allowedSwaps) {
        
        int n = source.size();
        vector<int> parent(n);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (auto& p : allowedSwaps) {
            unionSet(parent, p[0], p[1]);
        }
        unordered_map<int, unordered_map<int, int>> count;
        for (int i = 0; i < n; i++) {
            count[find(parent, i)][source[i]]++;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (count[find(parent, i)][target[i]]-- == 0) {
                res++;
            }
        }
        return res;
    }
    void unionSet(vector<int>& parent, int i, int j) {
        parent[find(parent, i)] = find(parent, j);
    }
    int find(vector<int>& parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
};