class Solution {
public:
    string arrangeWords(string text) {
        
        text[0] = char(tolower(text[0]));
        vector<string> words;
        string word;
        for (auto c: text) {
            if (c == ' ') {
                words.push_back(word);
                word.clear();
            } else {
                word += c;
            }
        }
        words.push_back(word);
        sort(words.begin(), words.end(), [](string &a, string &b) {
            return a.size() < b.size();
        });
        string res;
        for (auto &word: words) {
            res += word;
            res += " ";
        }
        res[0] = char(toupper(res[0]));
        res.pop_back();
        return res;
    }
};