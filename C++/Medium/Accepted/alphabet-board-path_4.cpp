class Solution {
public:
    string alphabetBoardPath(string target) {
        
        string ans;
        int r = 0, c = 0;
        for (char ch : target) {
            int nr = (ch - 'a') / 5;
            int nc = (ch - 'a') % 5;
            if (ch == 'z') {
                if (c > 0) {
                    ans += string(c, 'L');
                    c = 0;
                }
                if (r < nr) {
                    ans += string(nr - r, 'D');
                    r = nr;
                }
                ans += '!';
            } else {
                if (r > nr) {
                    ans += string(r - nr, 'U');
                    r = nr;
                }
                if (c < nc) {
                    ans += string(nc - c, 'R');
                    c = nc;
                }
                if (r < nr) {
                    ans += string(nr - r, 'D');
                    r = nr;
                }
                if (c > nc) {
                    ans += string(c - nc, 'L');
                    c = nc;
                }
                ans += '!';
            }
        }
        return ans;
    }
};