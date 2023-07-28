class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        
        vector<vector<int>> ans(n, vector<int>(n));
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) ans[t][i] = num++;
            t++;
            for (int i = t; i <= b; i++) ans[i][r] = num++;
            r--;
            for (int i = r; i >= l; i--) ans[b][i] = num++;
            b--;
            for (int i = b; i >= t; i--) ans[i][l] = num++;
            l++;
        }
        return ans;
    }
};