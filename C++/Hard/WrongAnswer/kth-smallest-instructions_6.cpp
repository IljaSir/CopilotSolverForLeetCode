class Solution {
public:
    string kthSmallestPath(vector<int>& destination, int k) {
        
        int row = destination[0], col = destination[1];
        int n = row + col;
        vector<vector<int>> C(n + 1, vector<int>(n + 1));
        C[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; ++j) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
        string ans;
        for (int i = 0; i < n; ++i) {
            if (row > 0) {
                int cnt = C[row + col - 1][row - 1];
                if (cnt >= k) {
                    ans.push_back('H');
                    --row;
                }
                else {
                    ans.push_back('V');
                    --col;
                    k -= cnt;
                }
            }
            else {
                ans.push_back('V');
                --col;
            }
        }
        return ans;
    }
};