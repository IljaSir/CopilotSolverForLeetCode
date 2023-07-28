class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        
        int n = dominoes.size();
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) || (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0])) {
                    count++;
                }
            }
        }
        return count;
    }
};