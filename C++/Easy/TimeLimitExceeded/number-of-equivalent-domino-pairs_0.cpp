class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        
        int count = 0;
        for (int i = 0; i < dominoes.size(); i++) {
            for (int j = i + 1; j < dominoes.size(); j++) {
                if (dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) {
                    count++;
                } else if (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0]) {
                    count++;
                }
            }
        }
        return count;
    }
};