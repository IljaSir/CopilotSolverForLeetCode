class Solution {
public:
    string alphabetBoardPath(string target) {
        
        string res;
        int i = 0, j = 0;
        for (char c: target) {
            int x = (c - 'a') / 5, y = (c - 'a') % 5;
            if (x < i) res += string(i - x, 'U');
            if (y < j) res += string(j - y, 'L');
            if (x > i) res += string(x - i, 'D');
            if (y > j) res += string(y - j, 'R');
            res += '!';
            i = x, j = y;
        }
        return res;
    }
};