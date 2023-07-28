class Solution {
public:
    int minimumCardPickup(vector<int>& cards) {
        
        int n = cards.size();
        if (n <= 1) return -1;
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            if (m.find(cards[i]) == m.end()) {
                m[cards[i]] = i;
            }
            else {
                int j = m[cards[i]];
                if (i - j >= 2) return i - j + 1;
            }
        }
        return -1;
    }
};