class Solution {
public:
    string alphabetBoardPath(string target) {
        
        string ans;
        int r = 0, c = 0;
        for (char ch : target) {
            int nr = (ch - 'a') / 5;
            int nc = (ch - 'a') % 5;
            if (nr < r) {
                ans += string(r - nr, 'U');
            }
            if (nc < c) {
                ans += string(c - nc, 'L');
            }
            if (nr > r) {
                ans += string(nr - r, 'D');
            }
            if (nc > c) {
                ans += string(nc - c, 'R');
            }
            ans += '!';
            r = nr;
            c = nc;
        }
        return ans;
    }
};