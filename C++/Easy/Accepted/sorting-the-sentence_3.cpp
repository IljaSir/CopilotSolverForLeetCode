class Solution {
public:
    string sortSentence(string s) {
        
        vector<string> words;
        string word;
        for (char c : s) {
            if (c == ' ') {
                words.push_back(word);
                word = "";
            } else if (c >= '1' && c <= '9') {
                word = word + c;
            } else {
                word = word + c;
            }
        }
        words.push_back(word);
        sort(words.begin(), words.end(), [](string a, string b) {
            return a.back() < b.back();
        });
        string ans;
        for (int i = 0; i < words.size(); i++) {
            if (i) ans += ' ';
            ans += words[i].substr(0, words[i].size() - 1);
        }
        return ans;
    }
};