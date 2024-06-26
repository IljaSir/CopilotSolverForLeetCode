class Solution {
public:
    bool checkOnesSegment(string s) {
        
        int i = 0;
        while (i < s.size() && s[i] == '1') {
            i++;
        }
        while (i < s.size() && s[i] == '0') {
            i++;
        }
        return i == s.size();
    }
};