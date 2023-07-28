class Solution {
public:
    string findLongestWord(string s, vector<string>& dictionary) {
        
        string res;
        for (string word : dictionary) {
            int i = 0;
            for (char c : s) {
                if (i < word.size() && c == word[i])
                    i++;
            }
            if (i == word.size() && word.size() >= res.size()) {
                if (word.size() > res.size() || word < res)
                    res = word;
            }
        }
        return res;
    }
};