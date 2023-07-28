class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        
        int count = 0;
        unordered_map<int, int> m;
        for (auto & d : dominoes) {
            int val = d[0] < d[1] ? d[0] * 10 + d[1] : d[1] * 10 + d[0];
            count += m[val]++;
        }
        return count;
    }
};