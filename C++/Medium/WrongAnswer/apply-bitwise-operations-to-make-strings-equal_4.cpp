class Solution {
public:
    bool makeStringsEqual(string s, string target) {
        
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == '0') {
                ++count0;
            }
            if (target[i] == '0') {
                ++count0;
            }
            if (s[i] == '1') {
                ++count1;
            }
            if (target[i] == '1') {
                ++count1;
            }
        }
        return count0 % 2 == 0 && count1 % 2 == 0;
    }
};