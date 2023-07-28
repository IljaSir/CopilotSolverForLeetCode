class Solution {
public:
    int minSwaps(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<int> rows(n);
        for (int i = 0; i < n; i++) {
            int j = n - 1;
            while (j >= 0 && grid[i][j] == 0) j--;
            rows[i] = j;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (rows[i] >= n - 1 - i) continue;
            int j = i + 1;
            while (j < n && rows[j] < n - 1 - i) j++;
            if (j == n) return -1;
            ans += j - i;
            while (j > i) {
                swap(rows[j], rows[j - 1]);
                j--;
            }
        }
        return ans;
    }
};