class Solution {
public:
    bool detectCapitalUse(string word) {
        
        int n = word.length();
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (word[i] >= 'A' && word[i] <= 'Z') {
                c++;
            }
        }
        return c == 0 || c == n || (c == 1 && word[0] >= 'A' && word[0] <= 'Z');
    }
};