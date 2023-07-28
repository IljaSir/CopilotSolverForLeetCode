class Solution {
public:
    string findLongestWord(string s, vector<string>& dictionary) {
        
        string ret = "";
        for (auto& word : dictionary) {
            int i = 0;
            for (auto c : s) {
                if (i < word.length() && word[i] == c) {
                    i++;
                }
            }
            if (i == word.length() && (i > ret.length() || (i == ret.length() && word < ret))) {
                ret = word;
            }
        }
        return ret;
    }
};