class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        
        vector<vector<int>> result;
        vector<int> temp;
        combineCore(n, k, 1, temp, result);
        return result;
    }
    void combineCore(int n, int k, int start, vector<int>& temp, vector<vector<int>>& result) {
        if (k == 0) {
            result.push_back(temp);
            return;
        }
        for (int i = start; i <= n; ++i) {
            temp.push_back(i);
            combineCore(n, k - 1, i + 1, temp, result);
            temp.pop_back();
        }
    }
};