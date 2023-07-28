class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        
        int count = 0;
        for (auto word : words) {
            int i = 0;
            for (; i < word.size(); ++i) {
                if (allowed.find(word[i]) == string::npos) {
                    break;
                }
            }
            if (i == word.size()) {
                ++count;
            }
        }
        return count;
    }
};