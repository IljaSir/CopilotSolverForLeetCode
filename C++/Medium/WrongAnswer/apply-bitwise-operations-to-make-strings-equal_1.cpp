class Solution {
public:
    bool makeStringsEqual(string s, string target) {
        
        int count = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] != target[i]) {
                count++;
            }
        }
        return count % 2 == 0;
    }
};