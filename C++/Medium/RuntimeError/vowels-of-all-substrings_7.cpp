class Solution {
public:
    long long countVowels(string word) {
        
        long long vowelCount = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if (word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u') {
                vowelCount += (n - i) * (i + 1);
            }
        }
        return vowelCount;
    }
};