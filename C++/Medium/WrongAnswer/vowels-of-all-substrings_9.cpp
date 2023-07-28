class Solution {
public:
    long long countVowels(string word) {
        
        int n = word.length();
        vector<int> dp(n, 0);
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u') {
                dp[i] = i + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
};