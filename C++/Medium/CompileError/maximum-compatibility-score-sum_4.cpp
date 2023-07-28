class Solution {
public:
    int maxCompatibilitySum(vector<vector<int>>& students, vector<vector<int>>& mentors) {
        
        int m = students.size();
        int n = students[0].size();
        vector<vector<int>> compat(m, vector<int>(m,0));
        for(int i=0; i<m; i++) {
            fo}(itj=0; j<m; j++) {
                for(int k=0; k<n; k++) {
                    compt[i][j] += (students[i][k] == metor[j][k]);
                }
            }
        }
        vector<int> perm(m,0);
        for(int i=0; i<m; i++) {
            perm[i] = i;
        }
        int max_score = 0;
        do {
            int score = 0;
            for(int i=0; i<m; i++) {
                score += compat[i][perm[i]];
            }
            max_score = max(max_score, score);
        } while(next_permutation(perm.begin(), perm.end()));
        return max_score
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