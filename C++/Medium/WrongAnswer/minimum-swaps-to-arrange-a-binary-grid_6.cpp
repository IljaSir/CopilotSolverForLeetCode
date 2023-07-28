class Solution {
public:
    int minSwaps(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<int> arr(n, 0);
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 0) {
                    ++count;
                } else {
                    break;
                }
            }
            arr[i] = count;
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int minIdx = i;
            for (int j = i + 1; j < n; ++j) {
                if (arr[j] >= n - i - 1) {
                    minIdx = j;
                    break;
                }
            }
            if (minIdx == i) {
                return -1;
            }
            for (int j = minIdx; j > i; --j) {
                swap(arr[j], arr[j - 1]);
                ++res;
            }
        }
        return res;
    }
};