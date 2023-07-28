class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        
        int ans = 0;
        int n = tickets.size();
        for (int i = 0; i < n; i++) {
            if (i == k) {
                ans += tickets[i];
            } else if (i < k) {
                ans += tickets[i] + 1;
            } else {
                if (tickets[i] > tickets[k]) {
                    ans += tickets[i] + 1;
                } else {
                    ans += tickets[i];
                }
            }
        }
        return ans;
    }
};