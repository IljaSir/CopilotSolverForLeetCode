class Solution {
public:
    int longestCommonSubpath(int n, vector<vector<int>>& paths) {
        
        int m = paths.size();
        int l = 0, r = 1e9;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (check(mid, n, m, paths)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
};