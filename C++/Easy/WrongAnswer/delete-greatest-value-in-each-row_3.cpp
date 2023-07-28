class Solution {
public:
    int deleteGreatestValue(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<int> maxInRow(m, 0);
        for (int i = 0; i < m; i++) {
            maxInRow[i] = *max_element(grid[i].begin(), grid[i].end());
        }
        int max = *max_element(maxInRow.begin(), maxInRow.end());
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == max) {
                    grid[i].erase(grid[i].begin() + j);
                    count += max;
                    break;
                }
            }
        }
        return count;
    }
    int maximumGain(string s, int x, int y) {
        vector<vector<int>> grid;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == 'a' || s[i] == 'b') {
                grid.push_back(vector<int>());
                while (i < s.length() && (s[i] == 'a' || s[i] == 'b')) {
                    grid[grid.size() - 1].push_back(s[i] == 'a' ? x : y);
                    i++;
                }
            }
        }
        int result = 0;
        while (grid.size() > 0) {
            result += deleteGreatestValue(grid);
            for (int i = 0; i < grid.size(); i++) {
                if (grid[i].size() == 0) {
                    grid.erase(grid.begin() + i);
                    i--;
                }
            }
        }
        return result;
    }
};