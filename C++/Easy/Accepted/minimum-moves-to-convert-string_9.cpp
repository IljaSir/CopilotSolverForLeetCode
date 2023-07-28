class Solution {
public:
    int minimumMoves(string s) {
        
        int n = s.length();
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'X') {
                c++;
                i += 2;
            }
        }
        return c;
    }
};