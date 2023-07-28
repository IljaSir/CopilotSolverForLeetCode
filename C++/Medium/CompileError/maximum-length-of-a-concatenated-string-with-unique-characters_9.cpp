class Solution {
public:
    int maxLength(vector<string>& arr) {
        
        return dfs(arr, 0, 0);
    }
};