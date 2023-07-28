class Solution {
public:
    int findCenter(vector<vector<int>>& edges) {
        
        int n = edges.size();
        vector<int> cnt(n+1,0);
        for (auto e: edges) {
            cnt[e[0]]++;
            cnt[e[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == n) return i;
        }
        return 0;
    }
};