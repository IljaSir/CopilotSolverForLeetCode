class Solution {
public:
    string sortSentence(string s) {
        
        vector<string> words;
        string word;
        for (auto c: s) {
            if (c == ' ') {
                words.push_back(word);
                word = "";
            } else if (c >= '0' && c <= '9') {
                word += string(1, c);
            } else {
                word += string(1, c);
            }
        }
        words.push_back(word);
        sort(words.begin(), words.end(), [](string &a, string &b) {
            return a.back() < b.back();
        });
        string res;
        for (auto word: words) {
            res += word.substr(0, word.size() - 1);
            res += ' ';
        }
        res.pop_back();
        return res;
    }
};