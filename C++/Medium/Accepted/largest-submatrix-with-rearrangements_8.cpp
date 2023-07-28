class Solution {
public:
    int largestSubmatrix(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        int ans = 0;
        vector<int> heights(n, 0);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    heights[j] = 0;
                }else{
                    heights[j]++;
                }
            }
            vector<int> tmp = heights;
            sort(tmp.begin(), tmp.end(), greater<int>());
            for(int j = 0; j < n; j++){
                ans = max(ans, tmp[j] * (j + 1));
            }
        }
        return ans;
    }
};