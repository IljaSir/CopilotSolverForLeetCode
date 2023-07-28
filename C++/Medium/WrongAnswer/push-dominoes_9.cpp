class Solution {
public:
    string pushDominoes(string dominoes) {
        
        int n = dominoes.size();
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        int l = -1e5;
        for (int i = 0; i < n; i++) {
            if (dominoes[i] == 'L') {
                l = 0;
            } else if (dominoes[i] == 'R') {
                l = -1e5;
            } else {
                l++;
            }
            left[i] = l;
        }
        int r = -1e5;
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes[i] == 'R') {
                r = 0;
            } else if (dominoes[i] == 'L') {
                r = -1e5;
            } else {
                r++;
            }
            right[i] = r;
        }
        for (int i = 0; i < n; i++) {
            if (left[i] == right[i]) {
                dominoes[i] = '.';
            } else if (left[i] < right[i]) {
                dominoes[i] = 'L';
            } else {
                dominoes[i] = 'R';
            }
        }
        return dominoes;
    }
};