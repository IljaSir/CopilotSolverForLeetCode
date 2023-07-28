class Solution {
public:
    int numSubmat(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        int res = 0;
        vector<int> height(n, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;
            }
            res += count(height);
        }
        return res;
    }
    int count(vector<int>& height) {
        int res = 0;
        for (int i = 0; i < height.size(); i++) {
            int minh = INT_MAX;
            for (int j = i; j < height.size(); j++) {
                minh = min(minh, height[j]);
                res += minh;
            }
        }
        return res;
    }
};