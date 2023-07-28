class Solution {
public:
    int minSwaps(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<int> zeros(n);
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) cnt++;
                else break;
            }
            zeros[i] = cnt;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (zeros[i] >= n - i - 1) continue;
            int j = i + 1;
            while (j < n && zeros[j] < n - i - 1) j++;
            if (j == n) return -1;
            res += j - i;
            while (j > i) {
                zeros[j] = zeros[j - 1];
                j--;
            }
        }
        return res;
    }
};