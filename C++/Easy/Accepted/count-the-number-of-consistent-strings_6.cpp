class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        
        int count = 0;
        for (auto word : words) {
            bool consistent = true;
            for (int i = 0; i < word.length(); i++) {
                if (allowed.find(word[i]) == std::string::npos) {
                    consistent = false;
                    break;
                }
            }
            if (consistent) count++;
        }
        return count;
    }
};