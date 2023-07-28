class Solution {
public:
    string alphabetBoardPath(string target) {
        
        int x = 0, y = 0;
        string res;
        for (char c : target) {
            int i = (c - 'a') / 5, j = (c - 'a') % 5;
            if (c == 'z') {
                res += string(y - j, 'L') + string(x - i, 'U') + '!';
            } else {
                res += string(x - i, 'U') + string(y - j, 'L') + '!' + string(j - y, 'R') + string(i - x, 'D');
            }
            x = i, y = j;
        }
        return res;
    }
};