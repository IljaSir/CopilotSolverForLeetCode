class Solution {
public:
    bool makeStringsEqual(string s, string target) {
        
        int n = s.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] != target[i]) {
                count++;
            }
        }
        return count % 2 == 0;
    }
};