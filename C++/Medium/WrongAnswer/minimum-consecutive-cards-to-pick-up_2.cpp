class Solution {
public:
    int minimumCardPickup(vector<int>& cards) {
        
        int n = cards.size();
        sort(cards.begin(), cards.end());
        int ans = n;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (cards[i] == cards[i - 1]) {
                count++;
            } else {
                ans = min(ans, n - count);
                count = 1;
            }
        }
        ans = min(ans, n - count);
        return ans == n ? -1 : ans;
    }
};