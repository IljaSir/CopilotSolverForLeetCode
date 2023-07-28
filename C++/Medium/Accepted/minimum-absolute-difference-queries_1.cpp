class Solution {
public:
    vector<int> minDifference(vector<int>& nums, vector<vector<int>>& queries) {
        
        int n = nums.size();
        vector<vector<int>> pos(101, vector<int>(n+1, 0));
        vector<int> res;
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j <= 100; ++j) {
                pos[j][i+1] = pos[j][i] + (nums[i] == j);
            }
        }
        for (auto& q : queries) {
            int l = q[0], r = q[1];
            int prev = -1, minDiff = INT_MAX;
            for (int i = 1; i <= 100; ++i) {
                if (pos[i][r+1] - pos[i][l] > 0) {
                    if (prev != -1) {
                        minDiff = min(minDiff, i - prev);
                    }
                    prev = i;
                }
            }
            res.push_back(minDiff == INT_MAX ? -1 : minDiff);
        }
        return res;
    }
};