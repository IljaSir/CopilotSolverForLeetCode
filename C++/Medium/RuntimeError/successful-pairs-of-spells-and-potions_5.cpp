class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        
        vector<int> pairs(spells.size());
        sort(potions.begin(), potions.end());
        for (int i = 0; i < spells.size(); i++) {
            int j = 0;
            for (; j < potions.size(); j++) {
                if (spells[i] * potions[j] >= success) {
                    break;
                }
            }
            pairs[i] = potions.size() - j;
        }
        return pairs;
    }
};