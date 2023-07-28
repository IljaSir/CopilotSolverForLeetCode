class Solution {
public:
    string largestMerge(string word1, string word2) {
        
        string res = "";
        while(word1.size() > 0 && word2.size() > 0) {
            if(word1 > word2) {
                res += word1[0];
                word1 = word1.substr(1, word1.size() - 1);
            } else {
                res += word2[0];
                word2 = word2.substr(1, word2.size() - 1);
            }
        }
        if(word1.size() > 0) {
            res += word1;
        } else {
            res += word2;
        }
        return res;
    }
};