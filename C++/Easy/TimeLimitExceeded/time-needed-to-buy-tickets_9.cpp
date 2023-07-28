class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        
        int n = tickets.size();
        int ans = 0;
        int i = 0;
        while (i < n) {
            int t = 0;
            while (i < n && t + tickets[i] <= tickets[k]) {
                t += tickets[i];
                i++;
            }
            ans += t;
            if (i < n) {
                ans += tickets[k] - t;
            }
        }
        return ans;
    }
};