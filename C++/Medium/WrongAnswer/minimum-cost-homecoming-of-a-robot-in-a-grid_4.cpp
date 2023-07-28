class Solution {
public:
    int minCost(vector<int>& startPos, vector<int>& homePos, vector<int>& rowCosts, vector<int>& colCosts) {
        
        int m = rowCosts.size();
        int n = colCosts.size();
        vector<int> rowCostsSorted = rowCosts;
        vector<int> colCostsSorted = colCosts;
        sort(rowCostsSorted.begin(), rowCostsSorted.end());
        sort(colCostsSorted.begin(), colCostsSorted.end());
        vector<int> rowCostsAcc(m);
        vector<int> colCostsAcc(n);
        rowCostsAcc[0] = rowCostsSorted[0];
        for (int i = 1; i < m; i++) {
            rowCostsAcc[i] = rowCostsAcc[i - 1] + rowCostsSorted[i];
        }
        colCostsAcc[0] = colCostsSorted[0];
        for (int i = 1; i < n; i++) {
            colCostsAcc[i] = colCostsAcc[i - 1] + colCostsSorted[i];
        }
        int r1 = startPos[0];
        int c1 = startPos[1];
        int r2 = homePos[0];
        int c2 = homePos[1];
        int cost = 0;
        if (r1 < r2) {
            cost += rowCostsAcc[r2 - 1];
            if (r1 > 0) {
                cost -= rowCostsAcc[r1 - 1];
            }
        } else {
            cost += rowCostsAcc[r1 - 1];
            if (r2 > 0) {
                cost -= rowCostsAcc[r2 - 1];
            }
        }
        if (c1 < c2) {
            cost += colCostsAcc[c2 - 1];
            if (c1 > 0) {
                cost -= colCostsAcc[c1 - 1];
            }
        } else {
            cost += colCostsAcc[c1 - 1];
            if (c2 > 0) {
                cost -= colCostsAcc[c2 - 1];
            }
        }
        return cost;
    }
};