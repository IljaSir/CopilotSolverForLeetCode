class Solution {
public:
    vector<int> executeInstructions(int n, vector<int>& startPos, string s) {
        
        int x = startPos[0];
        int y = startPos[1];
        vector<int> res(s.size(), 0);
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == 'U') {
                if (x == 0) {
                    res[i] = 0;
                    break;
                } else {
                    x--;
                }
            } else if (s[i] == 'D') {
                if (x == n - 1) {
                    res[i] = 0;
                    break;
                } else {
                    x++;
                }
            } else if (s[i] == 'L') {
                if (y == 0) {
                    res[i] = 0;
                    break;
                } else {
                    y--;
                }
            } else if (s[i] == 'R') {
                if (y == n - 1) {
                    res[i] = 0;
                    break;
                } else {
                    y++;
                }
            }
        }
        for (int i = s.size() - 2; i >= 0; --i) {
            if (res[i + 1] != 0) {
                res[i] = res[i + 1] - 1;
            }
        }
        return res;
    }
};