class Solution {
public:
    int latestDayToCross(int row, int col, vector<vector<int>>& cells) {
        
        vector<vector<int>> grid(row, vector<int>(col, 0));
        int days = cells.size();
        int low = 0, high = days;
        while (low < high) {
            int mid = low + (high - low) / 2;
            for (int i = 0; i < mid; i++) {
                grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
            }
            if (canCross(grid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
            for (int i = 0; i < mid; i++) {
                grid[cells[i][0] - 1][cells[i][1] - 1] = 0;
            }
        }
        return low;
    }
};