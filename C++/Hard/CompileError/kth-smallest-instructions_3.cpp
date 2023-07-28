class Solution {
public:
    string kthSmallestPath(vector<int>& destination, int k) {
        
        int row = destination[0], col = destination[1];
        string ans;
        while (row > 0 || col > 0) {
            if (row == 0) {
                ans.push_back('H');
                --col;
            } else if (col == 0) {
                ans.push_back('V');
                --row;
            } else {
                int cnt = 0;
                for (int i = 0; i < row; ++i) {
                    cnt += C(row + col - 1 - i, row - 1 - i);
                }
                if (cnt < k) {
                    ans.push_back('H');
                    --col;
                    k -= cnt;
                } else {
                    ans.push_back('V');
                    --row;
                }
            }
        }
        return ans;
    }
};