class Solution {
public:
    int maxCompatibilitySum(vector<vector<int>>& students, vector<vector<int>>& mentors) {
        
        int m = students.size();
        int n = students[0].size();
        vector<vector<int>> score(m, vector<int>(m, 0));
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < n; k++){
                    if(students[i][k] == mentors[j][k]){
                        score[i][j]++;
                    }
                }
            }
        }
        vector<int> perm(m, 0);
        for(int i = 0; i < m; i++){
            perm[i] = i;
        }
        int ans = 0;
        do{
            int s = 0;
            for(int i = 0; i < m; i++){
                s += score[i][perm[i]];
            }
            ans = max(ans, s);
        }while(next_permutation(perm.begin(), perm.end()));
        return ans;
    }
};