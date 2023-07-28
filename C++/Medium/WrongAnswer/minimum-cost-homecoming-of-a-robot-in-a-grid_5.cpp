class Solution {
public:
    int minCost(vector<int>& startPos, vector<int>& homePos, vector<int>& rowCosts, vector<int>& colCosts) {
        
        int m = rowCosts.size(), n = colCosts.size();
        vector<int> row(m), col(n);
        row[0] = rowCosts[0];
        col[0] = colCosts[0];
        for (int i = 1; i < m; i++) {
            row[i] = row[i - 1] + rowCosts[i];
        }
        for (int i = 1; i < n; i++) {
            col[i] = col[i - 1] + colCosts[i];
        }
        int res = 0;
        if (startPos[0] != homePos[0]) {
            res += row[min(startPos[0], homePos[0])];
        }
        if (startPos[1] != homePos[1]) {
            res += col[min(startPos[1], homePos[1])];
        }
        return res;
    }
};