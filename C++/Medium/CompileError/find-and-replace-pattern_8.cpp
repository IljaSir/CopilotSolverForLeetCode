class Solution {
public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        
        vector<string> res;
        for(string word : words){
            if(isMatch(word, pattern)){
                res.push_back(word);
            }
        }
        return res;
    }
};