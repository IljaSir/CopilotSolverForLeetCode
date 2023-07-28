class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        
        vector<int> count(100, 0);
        int res = 0;
        for (auto& d : dominoes) {
            int n = d[0] < d[1] ? d[0] * 10 + d[1] : d[1] * 10 + d[0];
            res += count[n];
            count[n]++;
        }
        return res;
    }
};