class Solution {
public:
    string arrangeWords(string text) {
        
        for (int i = 0; i < text.size(); i++) {
            if (i == 0) {
                text[i] = tolower(text[i]);
            }
            if (text[i] == ' ') {
                text[i+1] = toupper(text[i+1]);
            }
        }
        vector<string> words;
        string word;
        for (int i = 0; i < text.size(); i++) {
            if (text[i] == ' ') {
                words.push_back(word);
                word.clear();
            } else {
                word += text[i];
            }
        }
        words.push_back(word);
        sort(words.begin(), words.end(), [](const string& a, const string& b) {
            return a.size() < b.size();
        });
        string result;
        for (int i = 0; i < words.size(); i++) {
            if (i == 0) {
                words[i][0] = toupper(words[i][0]);
            }
            result += words[i];
            if (i != words.size() - 1) {
                result += ' ';
            }
        }
        return result;
    }
};