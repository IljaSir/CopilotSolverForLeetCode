class Solution {
public:
    string alphabetBoardPath(string target) {
        
        int x = 0;
        int y = 0;
        string res;
        for (auto c : target) {
            int x1 = (c - 'a') / 5;
            int y1 = (c - 'a') % 5;
            if (c == 'z') {
                while (y > y1) {
                    res += 'L';
                    --y;
                }
                while (x > x1) {
                    res += 'U';
                    --x;
                }
                res += '!';
            } else {
                while (x > x1) {
                    res += 'U';
                    --x;
                }
                while (y < y1) {
                    res += 'R';
                    ++y;
                }
                while (y > y1) {
                    res += 'L';
                    --y;
                }
                while (x < x1) {
                    res += 'D';
                    ++x;
                }
                res += '!';
            }
        }
        return res;
    }
};