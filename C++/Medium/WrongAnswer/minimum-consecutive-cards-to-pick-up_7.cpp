class Solution {
public:
    int minimumCardPickup(vector<int>& cards) {
        
        unordered_map<int, int> count;
        for (int card : cards) {
            count[card]++;
        }
        int minPickup = INT_MAX;
        for (auto& p : count) {
            if (p.second >= 2) {
                minPickup = min(minPickup, p.second);
            }
        }
        return minPickup == INT_MAX ? -1 : minPickup;
    }
};