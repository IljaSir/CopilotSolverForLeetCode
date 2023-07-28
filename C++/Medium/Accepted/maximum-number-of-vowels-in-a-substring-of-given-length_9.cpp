class Solution {
public:
    int maxVowels(string s, int k) {
        
        int n = s.length();
        int i = 0;
        int j = 0;
        int maxVowels = 0;
        int currVowels = 0;
        while(j < n) {
            if (j - i + 1 <= k) {
                if (s[j] == 'a' || s[j] == 'e' || s[j] == 'i' || s[j] == 'o' || s[j] == 'u') {
                    currVowels++;
                }
                j++;
            } else {
                if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                    currVowels--;
                }
                i++;
            }
            maxVowels = max(maxVowels, currVowels);
        }
        return maxVowels;
    }
};