class Solution {
public:
    bool checkOnesSegment(string s) {
        
        int n = s.size();
        for (int i = 1; i < n; i++) {
            if (s[i] == '1' && s[i - 1] == '0') {
                return false;
            }
        }
        return true;
    }
};