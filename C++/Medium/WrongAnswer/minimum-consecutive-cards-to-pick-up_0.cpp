class Solution {
public:
    int minimumCardPickup(vector<int>& cards) {
        
        int n = cards.size();
        if (n < 2) return -1;
        if (n == 2) {
            if (cards[0] == cards[1]) return 2;
            return -1;
        }
        unordered_map<int, int> cardMap;
        for (int i = 0; i < n; i++) {
            cardMap[cards[i]]++;
        }
        int maxCount = 0;
        for (auto it = cardMap.begin(); it != cardMap.end(); it++) {
            maxCount = max(maxCount, it->second);
        }
        return maxCount == 1 ? -1 : maxCount * 2;
    }
};