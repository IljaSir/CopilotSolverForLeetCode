class Solution {
public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        
        vector<string> result;
        for (const auto& word : words) {
            if (isMatch(word, pattern)) {
                result.push_back(word);
            }
        }
        return result;
    }
};