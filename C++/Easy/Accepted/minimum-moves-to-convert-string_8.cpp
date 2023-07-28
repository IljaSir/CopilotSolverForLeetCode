class Solution {
public:
    int minimumMoves(string s) {
        
        int i = 0;
        int count = 0;
        while (i < s.length()) {
            if (s[i] == 'X') {
                i += 3;
                count++;
            } else {
                i++;
            }
        }
        return count;
    }
};