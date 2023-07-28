class Solution {
public:
    int countPrefixes(vector<string>& words, string s) {
        
        int count = 0;
        for (auto word : words) {
            if (s.length() < word.length()) continue;
            if (s.substr(0, word.length()) == word) count++;
        }
        return count;
    }
    int numOfStrings(vector<string>& words, string s) {
        int count = 0;
        for (auto word : words) {
            if (s.length() < word.length()) continue;
            if (countPrefixes(words, word) > 0) count++;
        }
        return count;
    }
};