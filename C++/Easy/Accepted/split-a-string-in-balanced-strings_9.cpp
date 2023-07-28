class Solution {
public:
    int balancedStringSplit(string s) {
        
        int l = 0, r = 0, res = 0;
        for (char &c : s) {
            if (c == 'L') l++;
            else r++;
            if (l == r) {
                res++;
                l = r = 0;
            }
        }
        return res;
    }
};