class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        
        vector<int> values(n);
        iota(begin(values), end(values), 1);
        long long ans = 0;
        do {
            long long tmp = 0;
            for (auto &road: roads) {
                tmp += values[road[0]] + values[road[1]];
            }
            ans = max(ans, tmp);
        } while (next_permutation(begin(values), end(values)));
        return ans;
    }
};