class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        
        int n = spells.size(), m = potions.size();
        vector<int> ret(n, 0);
        sort(potions.begin(), potions.end());
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            for (int j = 0; j < m; ++j) {
                if (1LL * spells[i] * potions[j] >= success) {
                    cnt = m - j;
                    break;
                }
            }
            ret[i] = cnt;
        }
        return ret;
    }
};