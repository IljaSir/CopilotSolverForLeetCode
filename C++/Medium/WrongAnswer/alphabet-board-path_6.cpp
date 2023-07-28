class Solution {
public:
    string alphabetBoardPath(string target) {
        
        int x = 0, y = 0;
        string result;
        for (char c : target) {
            int x1 = (c - 'a') / 5;
            int y1 = (c - 'a') % 5;
            if (x1 > x) {
                result.append(x1 - x, 'D');
            }
            if (y1 > y) {
                result.append(y1 - y, 'R');
            }
            if (y1 < y) {
                result.append(y - y1, 'L');
            }
            if (x1 < x) {
                result.append(x - x1, 'U');
            }
            result.push_back('!');
            x = x1;
            y = y1;
        }
        return result;
    }
};