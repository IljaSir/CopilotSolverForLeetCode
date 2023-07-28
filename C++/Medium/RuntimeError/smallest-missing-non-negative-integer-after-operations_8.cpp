class Solution {
public:
    int findSmallestInteger(vector<int>& nums, int value) {
        
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int* count = new int[max + 1];
        for (int i = 0; i < max + 1; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < nums.size(); i++) {
            count[nums[i]]++;
        }
        int sum = 0;
        for (int i = 0; i < max + 1; i++) {
            sum += count[i];
            if (sum == i) {
                continue;
            } else {
                return i;
            }
        }
        return max + 1;
    }
    int maximumMinimumPath(vector<vector<int>>& A) {
        int row = A.size();
        int column = A[0].size();
        int** dp = new int*[row];
        for (int i = 0; i < row; i++) {
            dp[i] = new int[column];
            for (int j = 0; j < column; j++) {
                dp[i][j] = 0;
            }
        }
        dp[0][0] = A[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = min(dp[i - 1][0], A[i][0]);
        }
        for (int j = 1; j < column; j++) {
            dp[0][j] = min(dp[0][j - 1], A[0][j]);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = min(min(dp[i - 1][j], dp[i][j - 1]), A[i][j]);
            }
        }
        return dp[row - 1][column - 1];
    }
};