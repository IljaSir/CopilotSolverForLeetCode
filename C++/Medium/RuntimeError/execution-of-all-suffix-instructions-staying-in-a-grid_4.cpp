class Solution {
public:
    vector<int> executeInstructions(int n, vector<int>& startPos, string s) {
        
        int m = s.length();
        vector<int> res(m, 0);
        vector<int> d = {0, 1, 0, -1, 0};
        for (int i = 0; i < m; i++) {
            int x = startPos[0], y = startPos[1];
            int k = 0;
            for (; k < 4; k++) {
                if (s[i + k] == 'L') {
                    y += d[k];
                } else if (s[i + k] == 'R') {
                    y += d[k + 1];
                } else if (s[i + k] == 'U') {
                    x += d[k + 2];
                } else if (s[i + k] == 'D') {
                    x += d[k + 3];
                }
                if (x < 0 || x >= n || y < 0 || y >= n) {
                    break;
                }
            }
            res[i] = k;
        }
        return res;
    }
};