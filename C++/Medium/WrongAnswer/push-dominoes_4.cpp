class Solution {
public:
    string pushDominoes(string dominoes) {
        
        int n = dominoes.length();
        vector<int> left(n, -1), right(n, -1);
        for (int i = 0; i < n; i++) {
            if (dominoes[i] == 'L') {
                left[i] = i;
            } else if (dominoes[i] == 'R') {
                left[i] = -2;
            } else if (i > 0 && left[i - 1] != -1) {
                left[i] = left[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes[i] == 'R') {
                right[i] = i;
            } else if (dominoes[i] == 'L') {
                right[i] = -2;
            } else if (i < n - 1 && right[i + 1] != -1) {
                right[i] = right[i + 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (left[i] == -2 && right[i] == -2) {
                dominoes[i] = '.';
            } else if (left[i] == -2) {
                dominoes[i] = 'R';
            } else if (right[i] == -2) {
                dominoes[i] = 'L';
            } else if (right[i] > left[i]) {
                dominoes[i] = 'L';
            } else if (right[i] < left[i]) {
                dominoes[i] = 'R';
            } else {
                dominoes[i] = '.';
            }
        }
        return dominoes;
    }
};