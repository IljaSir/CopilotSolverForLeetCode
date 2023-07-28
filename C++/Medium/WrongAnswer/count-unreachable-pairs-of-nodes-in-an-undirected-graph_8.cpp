class Solution {
public:
    long long countPairs(int n, vector<vector<int>>& edges) {
        
        vector<int> v(n, 0);
        for (auto& e : edges) {
            v[e[0]]++;
            v[e[1]]++;
        }
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += (n - 1 - v[i]) * v[i];
        }
        return ans / 2;
    }
};