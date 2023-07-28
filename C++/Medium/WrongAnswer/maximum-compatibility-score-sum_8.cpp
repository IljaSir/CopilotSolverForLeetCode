class Solution {
public:
    int maxCompatibilitySum(vector<vector<int>>& students, vector<vector<int>>& mentors) {
        
        int m = students.size();
        int n = students[0].size();
        vector<int> used(m, 0);
        return dfs(students, mentors, used, n, 0, 0);
    }
    
    int dfs(vector<vector<int>>& students, vector<vector<int>>& mentors, vector<int>& used, int n, int cur, int score) {
        if (cur == n) {
            return score;
        }
        
        int m = students.size();
        int res = 0;
        for (int i = 0; i < m; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                res = max(res, dfs(students, mentors, used, n, cur + 1, score + getScore(students[cur], mentors[i])));
                used[i] = 0;
            }
        }
        return res;
    }
    
    int getScore(vector<int>& s, vector<int>& m) {
        int res = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == m[i]) {
                res++;
            }
        }
        return res;
    }
};