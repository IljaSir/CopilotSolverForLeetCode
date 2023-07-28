class Solution {
public:
    int balancedStringSplit(string s) {
        
        int count = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == 'L') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                count++;
            }
        }
        return count;
    }
};