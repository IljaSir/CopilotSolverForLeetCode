class Solution {
public:
    string alphabetBoardPath(string target) {
        
        string ret;
        int x = 0, y = 0;
        for (auto c : target) {
            int t = c - 'a';
            int tx = t / 5;
            int ty = t % 5;
            if (t == 25) {
                if (x != tx) {
                    for (int i = 0; i < abs(x - tx); ++i) {
                        ret.push_back(x < tx ? 'D' : 'U');
                    }
                }
                if (y != ty) {
                    for (int i = 0; i < abs(y - ty); ++i) {
                        ret.push_back(y < ty ? 'R' : 'L');
                    }
                }
            } else {
                if (y != ty) {
                    for (int i = 0; i < abs(y - ty); ++i) {
                        ret.push_back(y < ty ? 'R' : 'L');
                    }
                }
                if (x != tx) {
                    for (int i = 0; i < abs(x - tx); ++i) {
                        ret.push_back(x < tx ? 'D' : 'U');
                    }
                }
            }
            ret.push_back('!');
            x = tx;
            y = ty;
        }
        return ret;
    }
};