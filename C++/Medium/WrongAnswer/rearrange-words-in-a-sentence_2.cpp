class Solution {
public:
    string arrangeWords(string text) {
        
        text[0] = tolower(text[0]);
        vector<string> words;
        string word;
        for (char c : text) {
            if (c == ' ') {
                words.push_back(word);
                word = "";
            } else {
                word += c;
            }
        }
        words.push_back(word);
        sort(words.begin(), words.end(), [](string& a, string& b) {
            return a.size() < b.size();
        });
        words[0][0] = toupper(words[0][0]);
        string res;
        for (string& w : words) {
            res += w + ' ';
        }
        res.pop_back();
        return res;
    }
};