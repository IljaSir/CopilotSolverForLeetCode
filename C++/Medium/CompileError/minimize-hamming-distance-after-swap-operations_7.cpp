class Solution {
public:
    int minimumHammingDistance(vector<int>& source, vector<int>& target, vector<vector<int>>& allowedSwaps) {
        
        int n = source.size();
        vector<int> parent(n);
        iota(parent.begin(), parent.end(), 0);
        for (auto& p : allowedSwaps) {
            int a = p[0], b = p[1];
            int pa = find(parent, a), pb = find(parent, b);
            if (pa != pb) parent[pa] = pb;
        }
        unordered_map<int, unordered_map<int, int>> cnt;
        for (int i = 0; i < n; ++i) {
            int p = find(parent, i);
            cnt[p][source[i]]++;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int p = find(parent, i);
            if (cnt[p][target[i]] > 0) {
                cnt[p][target[i]]--;
            } else {
                ans++;
            }
        }
        return ans;
    }
};