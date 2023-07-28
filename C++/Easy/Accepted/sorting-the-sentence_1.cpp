class Solution {
public:
    string sortSentence(string s) {
        
        vector<string> words;
        string word;
        for (auto c: s) {
            if (c == ' ') {
                words.push_back(word);
                word.clear();
            } else {
                word.push_back(c);
            }
        }
        words.push_back(word);
        sort(words.begin(), words.end(), [](const string& a, const string& b) {
            return a.back() < b.back();
        });
        string res;
        for (auto& w: words) {
            res.append(w.begin(), w.end() - 1);
            res.push_back(' ');
        }
        res.pop_back();
        return res;
    }
};