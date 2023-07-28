class Solution {
public:
    int minSwaps(string s) {
        
        int n = s.length();
        int c1 = 0, c2 = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '[') c1++;
            else if (c1 > 0) c1--;
            else c2++;
        }
        return (c1 + 1) / 2;
    }
};