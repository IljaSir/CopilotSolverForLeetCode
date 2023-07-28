class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        
        string s;
        int i = 0;
        for (; i < word1.size() && i < word2.size(); i++) {
            s += word1[i];
            s += word2[i];
        }
        for (; i < word1.size(); i++) {
            s += word1[i];
        }
        for (; i < word2.size(); i++) {
            s += word2[i];
        }
        return s;
    }
};