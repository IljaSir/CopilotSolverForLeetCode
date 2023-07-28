class Solution {
public:
    int longestCommonSubpath(int n, vector<vector<int>>& paths) {
        
        int low = 1, high = 100000;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (check(n, paths, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
};