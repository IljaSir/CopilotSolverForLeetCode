class Solution {
public:
    int longestCommonSubpath(int n, vector<vector<int>>& paths) {
        
        int lo = 0, hi = 100000;
        while (lo < hi) {
            int mi = (lo + hi + 1) / 2;
            if (check(n, paths, mi))
                lo = mi;
            else
                hi = mi - 1;
        }
        return lo;
    }
};