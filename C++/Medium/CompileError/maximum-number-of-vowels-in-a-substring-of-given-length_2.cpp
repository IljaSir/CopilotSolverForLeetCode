class Solution {
public:
    int maxVowels(string s, int k) {
        
        int maxVowels = 0;
        int currentVowels = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < k) {
                if (isVowel(s[i])) {
                    currentVowels++;
                }
            } else {
                if (isVowel(s[i])) {
                    currentVowels++;
                }
                if (isVowel(s[i - k])) {
                    currentVowels--;
                }
            }
            maxVowels = max(maxVowels, currentVowels);
        }
        return maxVowels;
    }
};