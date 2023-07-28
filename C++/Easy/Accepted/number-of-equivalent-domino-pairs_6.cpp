class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        
        int count[10][10] = {0};
        for (auto domino : dominoes) {
            if (domino[0] > domino[1]) {
                swap(domino[0], domino[1]);
            }
            count[domino[0]][domino[1]]++;
        }
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = i; j <= 9; j++) {
                res += count[i][j] * (count[i][j] - 1) / 2;
            }
        }
        return res;
    }
};