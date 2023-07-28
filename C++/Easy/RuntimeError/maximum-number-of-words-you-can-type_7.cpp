class Solution {
public:
    int canBeTypedWords(string text, string brokenLetters) {
        
        int ans = 0, n = text.size();
        vector<int> broken(26, 0);
        for (char c : brokenLetters) {
            broken[c - 'a'] = 1;
        }
        for (int i = 0; i < n; ++i) {
            if (broken[text[i] - 'a'] == 0) {
                ++ans;
            }
            while (i < n && text[i] != ' ') {
                if (broken[text[i] - 'a'] == 1) {
                    --ans;
                    break;
                }
                ++i;
            }
        }
        return ans;
    }
};