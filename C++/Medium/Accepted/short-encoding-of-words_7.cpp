class Solution {
public:
    int minimumLengthEncoding(vector<string>& words) {
        
        int result = 0;
        unordered_set<string> word_set(words.begin(), words.end());
        for (string word : words) {
            for (int i = 1; i < word.size(); i++) {
                word_set.erase(word.substr(i));
            }
        }
        for (string word : word_set) {
            result += word.size() + 1;
        }
        return result;
    }
};