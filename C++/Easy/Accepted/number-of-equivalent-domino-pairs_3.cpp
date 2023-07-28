class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        
        unordered_map<int, int> m;
        int res = 0;
        for (auto d : dominoes) {
            int key = d[0] < d[1] ? d[0] * 10 + d[1] : d[1] * 10 + d[0];
            res += m[key]++;
        }
        return res;
    }
};