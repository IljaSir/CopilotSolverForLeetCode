class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        
        sort(spells.begin(), spells.end());
        sort(potions.begin(), potions.end());
        int N = spells.size(), M = potions.size();
        vector<int> res(N, 0);
        for (int i = 0; i < N; i++) {
            int lo = 0, hi = M;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (spells[i] * 1LL * potions[mid] < success) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            res[i] = M - lo;
        }
        return res;
    }
};