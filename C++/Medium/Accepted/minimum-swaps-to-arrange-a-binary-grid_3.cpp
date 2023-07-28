class Solution {
public:
    int minSwaps(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<int> zeros(n, 0);
        for(int i = 0; i < n; ++i) {
            for(int j = n - 1; j >= 0; --j) {
                if(grid[i][j] == 0) {
                    zeros[i]++;
                } else {
                    break;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            int j = i;
            while(j < n && zeros[j] < n - i - 1) {
                j++;
            }
            if(j == n) {
                return -1;
            }
            ans += j - i;
            for(int k = j; k > i; --k) {
                swap(zeros[k], zeros[k - 1]);
            }
        }
        return ans;
    }
};