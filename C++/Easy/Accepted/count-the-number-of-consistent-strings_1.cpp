class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        
        int count = 0;
        for (string word: words) {
            bool consistent = true;
            for (char c: word) {
                if (allowed.find(c) == string::npos) {
                    consistent = false;
                    break;
                }
            }
            if (consistent) count++;
        }
        return count;
    }
};