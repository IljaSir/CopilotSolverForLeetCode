class Solution {
public:
    string pushDominoes(string dominoes) {
        
        int n = dominoes.size();
        int i = 0;
        while (i < n) {
            if (dominoes[i] == '.') {
                i++;
                continue;
            }
            int j = i;
            while (j < n && dominoes[j] == dominoes[i]) {
                j++;
            }
            if (dominoes[i] == 'L') {
                for (int k = i; k < j; k++) {
                    dominoes[k] = 'L';
                }
            } else {
                if (j < n && dominoes[j] == 'L') {
                    int k = i;
                    while (k < j) {
                        dominoes[k++] = 'R';
                        dominoes[j--] = 'L';
                    }
                } else {
                    for (int k = i; k < j; k++) {
                        dominoes[k] = 'R';
                    }
                }
            }
            i = j;
        }
        return dominoes;
    }
};