class Solution {
public:
    int minSwaps(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int ans = 0;
        for(int i=0; i<n; i++) {
            int j = i;
            while(j<n && grid[j][i] == 0) j++;
            if(j == n) return -1;
            ans += j-i;
            for(int k=j; k>i; k--) {
                swap(grid[k], grid[k-1]);
            }
        }
        return ans;
    }
};