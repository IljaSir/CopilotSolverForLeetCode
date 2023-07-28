class Solution {
public:
    vector<int> executeInstructions(int n, vector<int>& startPos, string s) {
        
        vector<int> res(s.size(), 0);
        int x = startPos[0], y = startPos[1];
        int r = s.size() - 1;
        for (int i = s.size() - 1; i >= 0; i--) {
            if (s[i] == 'L') {
                if (y == 0) {
                    r = i - 1;
                } else {
                    y--;
                }
            } else if (s[i] == 'R') {
                if (y == n - 1) {
                    r = i - 1;
                } else {
                    y++;
                }
            } else if (s[i] == 'U') {
                if (x == 0) {
                    r = i - 1;
                } else {
                    x--;
                }
            } else {
                if (x == n - 1) {
                    r = i - 1;
                } else {
                    x++;
                }
            }
            res[i] = r - i + 1;
        }
        return res;
    }
};