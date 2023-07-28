class Solution {
public:
    string kthSmallestPath(vector<int>& destination, int k) {
        
        vector<vector<int>> comb(31, vector<int>(31, 0));
        comb[0][0] = 1;
        for (int i = 1; i < 31; i++) {
            comb[i][0] = 1;
            for (int j = 1; j < 31; j++) {
                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            }
        }
        int x = destination[1], y = destination[0];
        string ans;
        while (x > 0 || y > 0) {
            if (x > 0 && comb[x + y - 1][x - 1] >= k) {
                ans.push_back('H');
                x--;
            } else {
                if (x > 0) k -= comb[x + y - 1][x - 1];
                ans.push_back('V');
                y--;
            }
        }
        return ans;
    }
};