class Solution {
public:
    int countPrefixes(vector<string>& words, string s) {
        
        int count = 0;
        for(auto word : words) {
            if(word.size() <= s.size()) {
                if(s.substr(0, word.size()) == word) {
                    count++;
                }
            }
        }
        return count;
    }
};