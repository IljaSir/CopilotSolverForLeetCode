class Solution {
public:
    int canBeTypedWords(string text, string brokenLetters) {
        
        int ans = 0;
        vector<bool> broken(26, false);
        for (auto c : brokenLetters) broken[c - 'a'] = true;
        for (int i = 0; i < text.size();) {
            int j = i;
            while (j < text.size() && text[j] != ' ') {
                if (broken[text[j] - 'a']) {
                    ans--;
                    break;
                }
                j++;
            }
            ans++;
            i = j + 1;
        }
        return ans;
    }
};