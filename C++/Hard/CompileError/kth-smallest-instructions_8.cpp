class Solution {
public:
    string kthSmallestPath(vector<int>& destination, int k) {
        
        int row = destination[0], col = destination[1];
        string res = "";
        while (row > 0 || col > 0) {
            int ways = 0;
            if (row > 0) {
                ways = getWays(row + col - 1, row - 1);
            }
            if (k <= ways) {
                res += 'H';
                --row;
            } else {
                res += 'V';
                --col;
                k -= ways;
            }
        }
        return res;
    }
};