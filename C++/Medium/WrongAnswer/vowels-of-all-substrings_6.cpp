class Solution {
public:
    long long countVowels(string word) {
        
        long long ans = 0;
        int n = word.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u') {
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            ans += count;
            if (word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u') {
                count--;
            }
        }
        return ans;
    }
};