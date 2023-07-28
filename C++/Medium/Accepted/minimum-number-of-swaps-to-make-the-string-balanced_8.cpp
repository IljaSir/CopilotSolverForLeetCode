class Solution {
public:
    int minSwaps(string s) {
        
        int n = s.size();
        int l = 0, r = 0;
        for (char c : s) {
            if (c == '[') l++;
            else {
                if (l > 0) l--;
                else r++;
            }
        }
        return (r + 1) / 2;
    }
};