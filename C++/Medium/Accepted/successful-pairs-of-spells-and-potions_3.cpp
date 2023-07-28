class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        
        vector<int> res(spells.size(), 0);
        sort(potions.begin(), potions.end());
        for (int i = 0; i < spells.size(); ++i) {
            int j = 0, k = potions.size() - 1;
            while (j <= k) {
                int mid = (j + k) / 2;
                if ((long long)spells[i] * potions[mid] >= success) {
                    k = mid - 1;
                } else {
                    j = mid + 1;
                }
            }
            res[i] = potions.size() - j;
        }
        return res;
    }
};