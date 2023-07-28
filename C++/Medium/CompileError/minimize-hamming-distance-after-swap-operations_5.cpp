class Solution {
public:
    int minimumHammingDistance(vector<int>& source, vector<int>& target, vector<vector<int>>& allowedSwaps) {
        
        int n = source.size();
        vector<int> p(n);
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        auto find = [&](int x) {
            return x == p[x] ? x : p[x] = find(p[x]);
        };
        for (auto& v : allowedSwaps) {
            p[find(v[0])] = find(v[1]);
        }
        unordered_map<int, unordered_map<int, int>> cnt;
        for (int i = 0; i < n; ++i) {
            cnt[find(i)][source[i]]++;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (cnt[find(i)][target[i]]-- == 0) {
                ans++;
            }
        }
        return ans;
    }
};