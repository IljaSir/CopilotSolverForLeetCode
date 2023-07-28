class Solution {
public:
    string pushDominoes(string dominoes) {
        
        int n = dominoes.size();
        vector<int> left(n, -1);
        vector<int> right(n, -1);
        for (int i = 0; i < n; i++) {
            if (dominoes[i] == 'L') {
                left[i] = 0;
            } else if (dominoes[i] == 'R') {
                left[i] = -1;
            } else {
                if (i > 0) {
                    left[i] = left[i - 1];
                    if (left[i] != -1) {
                        left[i]++;
                    }
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes[i] == 'R') {
                right[i] = 0;
            } else if (dominoes[i] == 'L') {
                right[i] = -1;
            } else {
                if (i < n - 1) {
                    right[i] = right[i + 1];
                    if (right[i] != -1) {
                        right[i]++;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (left[i] == -1 && right[i] == -1) {
                dominoes[i] = '.';
            } else if (left[i] == -1) {
                dominoes[i] = 'R';
            } else if (right[i] == -1) {
                dominoes[i] = 'L';
            } else {
                if (left[i] < right[i]) {
                    dominoes[i] = 'L';
                } else if (left[i] > right[i]) {
                    dominoes[i] = 'R';
                } else {
                    dominoes[i] = '.';
                }
            }
        }
        return dominoes;
    }
};