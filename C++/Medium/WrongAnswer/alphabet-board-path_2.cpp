class Solution {
public:
    string alphabetBoardPath(string target) {
        
        string res;
        int r = 0, c = 0;
        for (char ch : target) {
            int nr = (ch - 'a') / 5, nc = (ch - 'a') % 5;
            if (ch == 'z') {
                if (r < nr) {
                    res.append(nr - r, 'D');
                } else if (r > nr) {
                    res.append(r - nr, 'U');
                }
                if (c < nc) {
                    res.append(nc - c, 'R');
                } else if (c > nc) {
                    res.append(c - nc, 'L');
                }
            } else {
                if (c < nc) {
                    res.append(nc - c, 'R');
                } else if (c > nc) {
                    res.append(c - nc, 'L');
                }
                if (r < nr) {
                    res.append(nr - r, 'D');
                } else if (r > nr) {
                    res.append(r - nr, 'U');
                }
            }
            res.push_back('!');
            r = nr, c = nc;
        }
        return res;
    }
};