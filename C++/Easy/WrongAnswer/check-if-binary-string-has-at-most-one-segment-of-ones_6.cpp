class Solution {
public:
    bool checkOnesSegment(string s) {
        
        bool flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '1') {
                if (!flag) {
                    flag = true;
                } else {
                    return false;
                }
            } else {
                flag = false;
            }
        }
        return true;
    }
};