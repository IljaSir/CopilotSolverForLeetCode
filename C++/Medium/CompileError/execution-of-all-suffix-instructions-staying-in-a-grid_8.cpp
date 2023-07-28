class Solution {
public:
    vector<int> executeInstructions(int n, vector<int>& startPos, string s) {
        
        vector<int> res(s.size(), 0);
        int row = startPos[0];
        int col = startPos[1];
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        while (i < s.size()) {
            if (s[i] == 'L') {
                if (col == 0) {
                    break;
                }
                col--;
            } else if (s[i] == 'R') {
                if (col == n - 1) {
                    break;
                }
                col++;
            } else if (s[i] == 'U') {
                if (row == 0) {
                    break;
                }
                row--;
            } else {
                if (row == n - 1) {
                    break;
                }
                row++;
            }
            i++;
            res[0]++;
        }
        j = s.size() - 1;
        row = startPos[0];
        col = startPos[1];
        while (j >= 0) {
            if (s[j] == 'L') {
                if (col == n - 1) {
                    break;
                }
                col++;
            } else if (s[j] == 'R') {
                if (col == 0) {
                    break;
                }
                col--;
            } else if (s[j] == 'U') {
                if (row == n - 1) {
                    break;
                }
                row++;
            } else {
                if (row == 0) {
                    break;
                }
                row--;
            }
            j--;
            res[s.size() - 1]++;
        }
        for (k = 1; k < s.size(); k++) {
            res[k] = res[k - 1];
            if (s[k - 1] == 'L') {
                if (col == n - 1) {
                    res[k]--;
                }
                col++;
            } else if (s[k - 1] == 'R') {
                if (col == 0) {
                    res[k]--;
                }
                col--;
            } else if (s[k - 1] == 'U') {
                if (row == n - 1) {
                    res[k]--;
                }
                row++;
            } else {
                if (row == 0) {
                    res[k]--;
    }
};