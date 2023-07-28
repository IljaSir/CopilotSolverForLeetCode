class Solution {
public:
    string reorderSpaces(string text) {
        
        int n = text.size();
        int spaces = 0;
        int words = 0;
        for (int i = 0; i < n; i++) {
            if (text[i] == ' ') {
                spaces++;
            }
        }
        string word = "";
        vector<string> v;
        for (int i = 0; i < n; i++) {
            if (text[i] == ' ') {
                if (word.size() > 0) {
                    words++;
                    v.push_back(word);
                    word = "";
                }
            } else {
                word += text[i];
            }
        }
        if (word.size() > 0) {
            words++;
            v.push_back(word);
        }
        if (words == 1) {
            return v[0] + string(spaces, ' ');
        }
        int spacesBetweenWords = spaces / (words - 1);
        int extraSpaces = spaces % (words - 1);
        string ans = "";
        for (int i = 0; i < words; i++) {
            ans += v[i];
            if (i != words - 1) {
                ans += string(spacesBetweenWords, ' ');
            }
        }
        ans += string(extraSpaces, ' ');
        return ans;
    }
};