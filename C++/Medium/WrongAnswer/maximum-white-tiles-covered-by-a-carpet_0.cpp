class Solution {
public:
    int maximumWhiteTiles(vector<vector<int>>& tiles, int carpetLen) {
        
        int n = tiles.size();
        vector<int> L(n), R(n);
        for (int i = 0; i < n; ++i) {
            L[i] = tiles[i][0];
            R[i] = tiles[i][1];
        }
        sort(L.begin(), L.end());
        sort(R.begin(), R.end());
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int l = L[i], r = l + carpetLen - 1;
            int j = upper_bound(R.begin(), R.end(), r) - R.begin();
            ans = max(ans, j - i);
        }
        return ans;
    }
};