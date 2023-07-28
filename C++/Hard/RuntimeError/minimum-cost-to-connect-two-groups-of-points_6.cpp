class Solution {
public:
    int connectTwoGroups(vector<vector<int>>& cost) {
        
        int row = cost.size();
        int col = cost[0].size();
        int res = INT_MAX;
        for(int i = 0; i < (1 << col); i++) {
            int tmp = 0;
            for(int j = 0; j < row; j++) {
                int min_val = INT_MAX;
                for(int k = 0; k < col; k++) {
                    int bit = 1 << k;
                    if(i & bit) {
                        min_val = min(min_val, cost[j][k]);
                    }
                }
                tmp += min_val;
            }
            res = min(res, tmp + dfs(cost, i, row, col));
        }
        return res;
    }
    
    int dfs(vector<vector<int>>& cost, int state, int row, int col) {
        if(row == cost.size()) return 0;
        int res = INT_MAX;
        for(int i = 0; i < (1 << col); i++) {
            int tmp = 0;
            for(int j = 0; j < col; j++) {
                int bit = 1 << j;
                if(i & bit) {
                    if(!(state & bit)) {
                        tmp += cost[row][j];
                    }
                }
            }
            res = min(res, tmp + dfs(cost, state | i, row + 1, col));
        }
        return res;
    }
};