class Solution {
public:
    string alphabetBoardPath(string target) {
        
        string res;
        int x = 0, y = 0;
        for (char c: target) {
            int i = (c - 'a') / 5, j = (c - 'a') % 5;
            while (x < i) {
                x++;
                res += "D";
            }
            while (x > i) {
                x--;
                res += "U";
            }
            while (y < j) {
                y++;
                res += "R";
            }
            while (y > j) {
                y--;
                res += "L";
            }
            res += "!";
        }
        return res;
    }
};