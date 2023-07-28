class Solution {
public:
    long long countVowels(string word) {
        
        long long ans = 0;
        int n = word.length();
        for(int i = 0; i < n; i++) {
            ans += (n - i) * (word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u');
        }
        return ans;
    }
};