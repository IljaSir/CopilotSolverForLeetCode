class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        
        string ret;
        int i = 0;
        for(; i < word1.size() && i < word2.size(); ++i) {
            ret.push_back(word1[i]);
            ret.push_back(word2[i]);
        }
        if(i < word1.size()) {
            ret += word1.substr(i);
        }
        if(i < word2.size()) {
            ret += word2.substr(i);
        }
        return ret;
    }
};