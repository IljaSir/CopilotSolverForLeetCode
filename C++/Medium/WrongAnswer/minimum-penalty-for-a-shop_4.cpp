class Solution {
public:
    int bestClosingTime(string customers) {
        
        int n = customers.size();
        vector<int> prefix(n);
        for (int i = 0; i < n; ++i) {
            prefix[i] = (i == 0 ? 0 : prefix[i - 1]) + (customers[i] == 'Y' ? 1 : 0);
        }
        int res = -1;
        int minPenalty = INT_MAX;
        for (int i = 0; i < n; ++i) {
            int penalty = i - prefix[i] + (n - i - 1 - (prefix[n - 1] - prefix[i]));
            if (penalty < minPenalty) {
                minPenalty = penalty;
                res = i;
            }
        }
        return res;
    }
};