class Solution {
public:
    int longestCommonSubpath(int n, vector<vector<int>>& paths) {
        
        int l = 0, r = 100000;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (check(n, paths, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
};