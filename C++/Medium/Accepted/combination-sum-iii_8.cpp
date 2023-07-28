class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        
        vector<vector<int>> ans;
        vector<int> temp;
        helper(ans, temp, k, n, 1);
        return ans;
    }
    void helper(vector<vector<int>>& ans, vector<int>& temp, int k, int n, int start) {
        if (temp.size() == k) {
            if (n == 0)
                ans.push_back(temp);
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (n - i < 0)
                break;
            temp.push_back(i);
            helper(ans, temp, k, n - i, i + 1);
            temp.pop_back();
        }
    }
};