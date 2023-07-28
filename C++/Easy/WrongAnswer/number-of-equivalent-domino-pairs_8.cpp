class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        
        int res = 0;
        int count[10][10] = {0};
        for (auto& d: dominoes) {
            res += count[d[0]][d[1]]++;
            if (d[0] != d[1]) {
                res += count[d[1]][d[0]]++;
            }
        }
        return res;
    }
};