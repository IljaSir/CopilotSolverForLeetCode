class Solution {
public:
    string findLongestWord(string s, vector<string>& dictionary) {
        
        sort(dictionary.begin(), dictionary.end(), [](const string& a, const string& b) {
            return a.length() == b.length() ? a < b : a.length() > b.length();
        });
        for (const string& word : dictionary) {
            int i = 0;
            for (char c : s) {
                if (i < word.length() && word[i] == c) {
                    i++;
                }
            }
            if (i == word.length()) {
                return word;
            }
        }
        return "";
    }
};