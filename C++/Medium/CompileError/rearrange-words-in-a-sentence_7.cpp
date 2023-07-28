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
        sort(woresult;
    }
};