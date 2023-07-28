class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        
        int n = tickets.size();
        if (n == 1) return tickets[0];
        vector<int> suffix(n, 0);
        suffix[n - 1] = tickets[n - 1];
        for (int i = n - 2; i >= 0; --i) suffix[i] = suffix[i + 1] + tickets[i];
        int ans = suffix[0];
        for (int i = 0; i < n; ++i) {
            int sum = suffix[i];
            int cnt = (int)ceil((double)sum / (double)n);
            int cur = cnt * n;
            if (i <= k) cur -= suffix[k];
            else cur -= suffix[i - 1];
            ans = max(ans, cur);
        }
        return ans;
    }
};