class Solution {
public:
    vector<string> printVertically(string s) {
        
        vector<string> words;
        string word;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == ' ') {
                words.push_back(word);
                word.clear();
            } else {
                word.push_back(s[i]);
            }
        }
        words.push_back(word);
        int maxLen = 0;
        for (int i = 0; i < words.size(); ++i) {
            maxLen = max(maxLen, (int)words[i].size());
        }
        vector<string> res;
        for (int i = 0; i < maxLen; ++i) {
            string line;
            for (int j = 0; j < words.size(); ++j) {
                if (i < words[j].size()) {
                    line.push_back(words[j][i]);
                } else {
                    line.push_back(' ');
                }
            }
            while (!line.empty() && line.back() == ' ') {
                line.pop_back();
            }
            res.push_back(line);
        }
        return res;
    }
};