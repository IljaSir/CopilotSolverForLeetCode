class Solution {
public:
    int countVowelSubstrings(string word) {
        
        int n = word.length();
        int dp[5] = {0};
        int count = 0;
        for(int i = 0; i < n; i++){
            char ch = word[i];
            if(ch == 'a'){
                dp[0] = 1;
            }
            else if(ch == 'e'){
                dp[1] = dp[0];
            }
            else if(ch == 'i'){
                dp[2] = dp[1];
            }
            else if(ch == 'o'){
                dp[3] = dp[2];
            }
            else if(ch == 'u'){
                dp[4] = dp[3];
            }
            count += dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
        }
        return count;
    }
};