class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        
        vector<int> result(spells.size(), 0);
        sort(spells.begin(), spells.end());
        sort(potions.begin(), potions.end());
        int i = 0, j = 0;
        while (i < spells.size() && j < potions.size()) {
            if (static_cast<long long>(spells[i]) * potions[j] >= success) {
                result[i] += potions.size() - j;
                ++i;
            } else {
                ++j;
            }
        }
        return result;
    }
};