class Solution {
public:
    vector<string> printVertically(string s) {
        
        vector<string> words;
        int maxLen = 0;
        int curLen = 0;
        string word;
        for (auto c : s) {
            if (c == ' ') {
                words.push_back(word);
                maxLen = max(maxLen, curLen);
                curLen = 0;
                word = "";
            } else {
                word += c;
                curLen++;
            }
        }
        words.push_back(word);
        maxLen = max(maxLen, curLen);
        
        vector<string> res;
        for (int i = 0; i < maxLen; i++) {
            string s;
            for (auto w : words) {
                if (i < w.size()) {
                    s += w[i];
                } else {
                    s += ' ';
                }
            }
            while (s.back() == ' ') {
                s.pop_back();
            }
            res.push_back(s);
        }
        return res;
    }
};