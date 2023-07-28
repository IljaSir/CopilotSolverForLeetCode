class Solution {
public:
    vector<string> printVertically(string s) {
        
        vector<string> words;
        int maxLen = 0;
        string word;
        for (char c : s) {
            if (c == ' ') {
                maxLen = max(maxLen, (int)word.size());
                words.push_back(word);
                word = "";
            } else {
                word += c;
            }
        }
        maxLen = max(maxLen, (int)word.size());
        words.push_back(word);
        vector<string> result;
        for (int i = 0; i < maxLen; ++i) {
            string line;
            for (string& word : words) {
                if (i < word.size()) {
                    line += word[i];
                } else {
                    line += " ";
                }
            }
            while (line.back() == ' ') {
                line.pop_back();
            }
            result.push_back(line);
        }
        return result;
    }
};