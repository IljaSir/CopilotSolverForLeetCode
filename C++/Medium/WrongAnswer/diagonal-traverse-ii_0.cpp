class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& nums) {
        
        int m = nums.size();
        int n = 0;
        for (int i = 0; i < m; i++) {
            n = max(n, (int)nums[i].size());
        }
        vector<vector<int>> arr(m + n - 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < nums[i].size(); j++) {
                arr[i + j].push_back(nums[i][j]);
            }
        }
        vector<int> res;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 0) {
                for (int j = arr[i].size() - 1; j >= 0; j--) {
                    res.push_back(arr[i][j]);
                }
            } else {
                for (int j = 0; j < arr[i].size(); j++) {
                    res.push_back(arr[i][j]);
                }
            }
        }
        return res;
    }
};