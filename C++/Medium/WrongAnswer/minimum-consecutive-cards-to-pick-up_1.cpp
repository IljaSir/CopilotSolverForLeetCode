class Solution {
public:
    int minimumCardPickup(vector<int>& cards) {
        
        unordered_map<int, int> m;
        int n = cards.size();
        for (int i = 0; i < n; i++) {
            m[cards[i]]++;
        }
        int ans = INT_MAX;
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second >= 2) {
                ans = min(ans, it->second);
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};