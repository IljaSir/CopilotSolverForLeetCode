class Solution {
public:
    string pushDominoes(string dominoes) {
        
        int n = dominoes.size();
        int l = -1, r = -1;
        for (int i = 0; i < n; i++) {
            if (dominoes[i] == 'R') {
                r = i;
            } else if (dominoes[i] == 'L') {
                if (r == -1) {
                    for (int j = l + 1; j < i; j++) {
                        dominoes[j] = 'L';
                    }
                } else {
                    for (int j = r + 1; j < i; j++) {
                        if ((j - r) == (i - j)) {
                            dominoes[j] = '.';
                        } else if ((j - r) > (i - j)) {
                            dominoes[j] = 'L';
                        } else {
                            dominoes[j] = 'R';
                        }
                    }
                    r = -1;
                }
                l = i;
            }
        }
        if (r != -1) {
            for (int j = r + 1; j < n; j++) {
                dominoes[j] = 'R';
            }
        }
        return dominoes;
    }
};