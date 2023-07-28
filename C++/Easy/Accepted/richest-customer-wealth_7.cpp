class Solution {
public:
    int maximumWealth(vector<vector<int>>& accounts) {
        
        int max = 0;
        for (auto &row : accounts) {
            int sum = 0;
            for (auto &val : row) {
                sum += val;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
};