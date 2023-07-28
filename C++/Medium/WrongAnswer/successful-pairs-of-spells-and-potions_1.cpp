class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        
        vector<int> ans(spells.size(), 0);
        sort(potions.begin(), potions.end());
        for (int i = 0; i < spells.size(); ++i) {
            auto it = upper_bound(potions.begin(), potions.end(), success / spells[i]);
            ans[i] = potions.end() - it;
        }
        return ans;
    }
};