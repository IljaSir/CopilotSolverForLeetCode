class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        
        int result = words.size();
        for (auto word : words) {
            for (auto c : word) {
                if (allowed.find(c) == string::npos) {
                    result--;
                    break;
                }
            }
        }
        return result;
    }
};