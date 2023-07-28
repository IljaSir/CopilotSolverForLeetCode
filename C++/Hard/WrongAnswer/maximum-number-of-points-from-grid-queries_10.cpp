class Solution {
public:
    vector<int> maxPoints(vector<vector<int>>& grid, vector<int>& queries) {
        
        vector<vector<int>> prefix(grid.size() + 1, vector<int>(grid[0].size() + 1, 0));
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                prefix[i + 1][j + 1] = prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j] + grid[i][j];
            }
        }
        vector<int> res;
        for (auto q: queries) {
            int maxPoints = 0;
            for (int i = 0; i < grid.size(); i++) {
                for (int j = 0; j < grid[0].size(); j++) {
                    if (grid[i][j] > q) {
                        int start = i, end = grid.size();
                        while (start < end) {
                            int mid = start + (end - start) / 2;
                            int sum = prefix[mid + 1][j + 1] - prefix[i][j + 1] - prefix[mid + 1][j] + prefix[i][j];
                            if (sum > q * (mid - i + 1)) {
                                end = mid;
                            } else {
                                start = mid + 1;
                            }
                        }
                        maxPoints = max(maxPoints, start - i);
                    }
                }
            }
            res.push_back(maxPoints);
        }
        return res;
    }
};