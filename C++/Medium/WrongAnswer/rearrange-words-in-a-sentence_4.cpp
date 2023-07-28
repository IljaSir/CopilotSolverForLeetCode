class Solution {
public:
    string arrangeWords(string text) {
        
        text[0] = tolower(text[0]);
        vector<string> words;
        string word;
        stringstream ss(text);
        while (ss >> word) {
            words.push_back(word);
        }
        sort(words.begin(), words.end(), [](const string &a, const string &b) {
            return a.size() < b.size();
        });
        string result;
        for (const auto &w : words) {
            result += w + ' ';
        }
        result.pop_back();
        result[0] = toupper(result[0]);
        return result;
    }
};