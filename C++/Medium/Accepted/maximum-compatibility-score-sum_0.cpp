class Solution {
public:
    int maxCompatibilitySum(vector<vector<int>>& students, vector<vector<int>>& mentors) {
        
        int m = students.size();
        int n = students[0].size();
        vector<vector<int>> score(m, vector<int>(m, 0));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j) {
                for (int k = 0; k < n; ++k) {
                    score[i][j] += students[i][k] == mentors[j][k];
                }
            }
        }
        
        vector<int> perm(m);
        for (int i = 0; i < m; ++i) {
            perm[i] = i;
        }
        
        int ans = 0;
        do {
            int sum = 0;
            for (int i = 0; i < m; ++i) {
                sum += score[i][perm[i]];
            }
            ans = max(ans, sum);
        } while (next_permutation(perm.begin(), perm.end()));
        
        return ans;
    }
};