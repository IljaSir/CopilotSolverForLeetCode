class Solution {
public:
    int minCost(vector<int>& startPos, vector<int>& homePos, vector<int>& rowCosts, vector<int>& colCosts) {
        
        int m = rowCosts.size();
        int n = colCosts.size();
        int totalCost = 0;
        for (int i = 0; i < m; ++i) {
            totalCost += rowCosts[i];
        }
        for (int i = 0; i < n; ++i) {
            totalCost += colCosts[i];
        }
        return totalCost - min(rowCosts[startPos[0]], rowCosts[homePos[0]]) - min(colCosts[startPos[1]], colCosts[homePos[1]]);
    }
};