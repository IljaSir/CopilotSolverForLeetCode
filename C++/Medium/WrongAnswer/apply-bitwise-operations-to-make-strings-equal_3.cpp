class Solution {
public:
    bool makeStringsEqual(string s, string target) {
        
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == '0') {
                ++count0;
            } else {
                ++count1;
            }
        }
        for (int i = 0; i < target.size(); ++i) {
            if (target[i] == '0') {
                --count0;
            } else {
                --count1;
            }
        }
        return count0 == 0 && count1 == 0;
    }
};