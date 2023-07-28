class Solution {
public:
    int minimumCardPickup(vector<int>& cards) {
        
        int n = cards.size();
        unordered_map<int, int> um;
        for (int i = 0; i < n; i++) {
            um[cards[i]]++;
        }
        int min = INT_MAX;
        for (auto it = um.begin(); it != um.end(); it++) {
            if (it->second < 2) {
                continue;
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (cards[i] == it->first) {
                    count++;
                }
                if (count == 2) {
                    break;
                }
                min = std::min(min, n - i - 1);
            }
        }
        return min == INT_MAX ? -1 : min;
    }
};