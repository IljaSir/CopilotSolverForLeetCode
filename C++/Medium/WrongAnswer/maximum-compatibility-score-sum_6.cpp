class Solution {
public:
    int maxCompatibilitySum(vector<vector<int>>& students, vector<vector<int>>& mentors) {
        
        int ans = 0;
        int n = students.size();
        int m = students[0].size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += students[i][j] == mentors[i][j];
            }
        }
        return ans;
    }
};