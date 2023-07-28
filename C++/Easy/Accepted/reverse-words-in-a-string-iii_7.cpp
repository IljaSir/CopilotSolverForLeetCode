class Solution {
public:
    string reverseWords(string s) {
        
        string result;
        string word;
        for (char c : s) {
            if (c != ' ') {
                word.push_back(c);
            } else {
                reverse(word.begin(), word.end());
                result += word;
                result += ' ';
                word.clear();
            }
        }
        reverse(word.begin(), word.end());
        result += word;
        return result;
    }
};