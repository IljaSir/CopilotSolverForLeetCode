class Solution {
public:
    int countVowelSubstrings(string word) {
        
        int a = 0, e = 0, i = 0, o = 0, u = 0, n = word.length();
        for (int j = 0; j < n; j++) {
            if (word[j] == 'a') {
                a = 1 + a + e + i + o + u;
            } else if (word[j] == 'e') {
                e = e + i + o + u;
            } else if (word[j] == 'i') {
                i = i + o + u;
            } else if (word[j] == 'o') {
                o = o + u;
            } else if (word[j] == 'u') {
                u = u + 1;
            }
        }
        return a;
    }
};