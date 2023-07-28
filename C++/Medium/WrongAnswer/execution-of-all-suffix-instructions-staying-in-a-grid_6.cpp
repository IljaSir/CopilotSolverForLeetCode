class Solution {
public:
    vector<int> executeInstructions(int n, vector<int>& startPos, string s) {
        
        vector<int> res(s.size(), 0);
        vector<vector<int>> dp(n, vector<int>(n, 0));
        int row = startPos[0], col = startPos[1];
        for(int i = 0; i < s.size(); ++i) {
            switch(s[i]) {
                case 'U':
                    row = max(row - 1, 0);
                    break;
                case 'D':
                    row = min(row + 1, n - 1);
                    break;
                case 'L':
                    col = max(col - 1, 0);
                    break;
                case 'R':
                    col = min(col + 1, n - 1);
                    break;
            }
            dp[row][col] = i + 1;
        }
        row = startPos[0], col = startPos[1];
        for(int i = 0; i < s.size(); ++i) {
            res[i] = dp[row][col] - i;
            switch(s[i]) {
                case 'U':
                    row = max(row - 1, 0);
                    break;
                case 'D':
                    row = min(row + 1, n - 1);
                    break;
                case 'L':
                    col = max(col - 1, 0);
                    break;
                case 'R':
                    col = min(col + 1, n - 1);
                    break;
            }
        }
        return res;
    }
};