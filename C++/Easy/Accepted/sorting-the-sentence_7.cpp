class Solution {
public:
    string sortSentence(string s) {
        
        vector<string> words(9);
        int wordIndex = 0;
        string word;
        for (char c : s) {
            if (c >= 'a' && c <= 'z') {
                word += c;
            } else if (c >= 'A' && c <= 'Z') {
                word += c;
            } else if (c >= '1' && c <= '9') {
                words[c - '1'] = word;
                word = "";
            }
        }
        string result;
        for (string w : words) {
            if (w.length() > 0) {
                result += w + " ";
            }
        }
        result.pop_back();
        return result;
    }
};