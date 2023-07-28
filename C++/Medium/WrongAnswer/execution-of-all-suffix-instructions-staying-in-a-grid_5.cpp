class Solution {
public:
    vector<int> executeInstructions(int n, vector<int>& startPos, string s) {
        
        int m = s.size();
        vector<int> res(m, 0);
        int x = startPos[0], y = startPos[1];
        int left = y, right = n - y - 1, up = n - x - 1, down = x;
        for (int i = m - 1; i >= 0; i--) {
            if (s[i] == 'L' && left > 0) {
                left--;
                res[i]++;
            } else if (s[i] == 'R' && right > 0) {
                right--;
                res[i]++;
            } else if (s[i] == 'U' && up > 0) {
                up--;
                res[i]++;
            } else if (s[i] == 'D' && down > 0) {
                down--;
                res[i]++;
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            res[i] += res[i + 1];
        }
        return res;
    }
};