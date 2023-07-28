class Solution {
public:
    string reorderSpaces(string text) {
        
        string res;
        int spaces = 0;
        for (auto c : text) {
            if (c == ' ') {
                ++spaces;
            }
        }
        vector<string> words;
        string word;
        for (auto c : text) {
            if (c == ' ') {
                if (!word.empty()) {
                    words.push_back(word);
                    word.clear();
                }
            } else {
                word.push_back(c);
            }
        }
        if (!word.empty()) {
            words.push_back(word);
        }
        if (words.size() == 1) {
            res = words[0];
            for (int i = 0; i < spaces; ++i) {
                res.push_back(' ');
            }
            return res;
        }
        int spaceNum = spaces / (words.size() - 1);
        int extraSpace = spaces % (words.size() - 1);
        for (int i = 0; i < words.size(); ++i) {
            if (i != 0) {
                for (int j = 0; j < spaceNum; ++j) {
                    res.push_back(' ');
                }
            }
            res += words[i];
        }
        for (int i = 0; i < extraSpace; ++i) {
            res.push_back(' ');
        }
        return res;
    }
};