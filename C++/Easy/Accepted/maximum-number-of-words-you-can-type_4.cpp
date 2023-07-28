class Solution {
public:
    int canBeTypedWords(string text, string brokenLetters) {
        
        int ans = 0;
        for (int i = 0, j = 0; i < text.size(); i = j) {
            while (j < text.size() && text[j] != ' ') j++;
            bool ok = true;
            for (int k = i; k < j; k++) {
                if (brokenLetters.find(text[k]) != string::npos) {
                    ok = false;
                    break;
                }
            }
            ans += ok;
            j++;
        }
        return ans;
    }
};