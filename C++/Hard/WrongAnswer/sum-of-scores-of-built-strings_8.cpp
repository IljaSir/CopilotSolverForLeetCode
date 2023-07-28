class Solution {
public:
    long long sumScores(string s) {
        
        int n = s.length();
        int score = 0;
        int maxScore = 0;
        for(int i = n - 1; i >= 0; i--){
            if(s[i] == s[n - 1]){
                score++;
            }
            else{
                score = 0;
            }
            maxScore = max(maxScore, score);
        }
        return (long long)maxScore * n + (long long)(n - 1) * n / 2;
    }
};