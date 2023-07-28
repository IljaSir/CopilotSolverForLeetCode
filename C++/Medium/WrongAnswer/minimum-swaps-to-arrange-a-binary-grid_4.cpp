class Solution {
public:
    int minSwaps(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<int> lastZero(n, n);
        for (int i = 0; i < n; ++i) {
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 0) {
                    lastZero[i] = j;
                } else {
                    break;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (lastZero[i] >= n - i - 1) {
                continue;
            }
            int j = i + 1;
            while (j < n && lastZero[j] < n - i - 1) {
                ++j;
            }
            if (j == n) {
                return -1;
            }
            ans += j - i;
            for (int k = j; k > i; --k) {
                swap(lastZero[k], lastZero[k - 1]);
            }
        }
        return ans;
    }
};