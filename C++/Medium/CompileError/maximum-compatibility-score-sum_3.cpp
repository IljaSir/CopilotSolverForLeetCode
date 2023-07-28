class Solution {
public:
    int maxCompatibilitySum(vector<vector<int>>& students, vector<vector<int>>& mentors) {
        
        int m = students.size();
        int n = students[0].size();
        
        vector<int> perm(m);
        for (int i = 0; i < m; i++) {
            perm[i = i;
        }
        
        int maxScore = 0;
        do {
            int score = 0;
            for (int i = 0; i < m; i++) {
                score += getScore(students[i], mentors[perm[i]]);
            }
            maxScore = max(maxScore, score);
        } while (next_permutation(perm.begin(), perm.end()));
        
        return maxScore;
    }
    
    int getScore(vector<int>& student, vector<int>& mentor) {
        int score = 0;
        for (int i = 0; i < student.size(); i++) {
            if (student[i] == mentor[i]) {
                score++
                    score[i][j] += students[i][k] == mentors[j][k];
                }
            rn score;
    }
};