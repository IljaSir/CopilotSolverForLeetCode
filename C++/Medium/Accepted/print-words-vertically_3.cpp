class Solution {
public:
    vector<string> printVertically(string s) {
        
        vector<string> res;
        vector<string> words;
        string word;
        for (auto c : s) {
            if (c == ' ') {
                words.push_back(word);
                word.clear();
            } else {
                word.push_back(c);
            }
        }
        words.push_back(word);
        int maxLen = 0;
        for (auto w : words) {
            maxLen = max(maxLen, (int)w.size());
        }
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