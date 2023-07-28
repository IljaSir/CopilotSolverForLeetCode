class Solution {
public:
    int minimumCardPickup(vector<int>& cards) {
        
        int n = cards.size();
        if(n == 1) return -1;
        unordered_map<int, int> mp;
        int ans = n;
        for(int i = 0; i < n; i++) {
            if(mp.find(cards[i]) != mp.end()) {
                ans = min(ans, i - mp[cards[i]] + 1);
            }
            mp[cards[i]] = i;
        }
        if(ans == n) return -1;
        return ans;
    }
};