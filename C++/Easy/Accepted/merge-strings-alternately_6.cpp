class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        
        string result;
        int i = 0;
        for (; i < word1.size() && i < word2.size(); i++) {
            result += word1[i];
            result += word2[i];
        }
        if (i < word1.size()) {
            result += word1.substr(i);
        } else if (i < word2.size()) {
            result += word2.substr(i);
        }
        return result;
    }
};