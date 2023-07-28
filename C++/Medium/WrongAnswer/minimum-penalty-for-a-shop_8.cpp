class Solution {
public:
    int bestClosingTime(string customers) {
        
        int n = customers.size();
        int penalty = 0;
        int res = 0;
        int minPenalty = n;
        for (int i = 0; i < n; ++i) {
            if (customers[i] == 'N') {
                ++penalty;
            }
        }
        if (penalty < minPenalty) {
            minPenalty = penalty;
            res = 0;
        }
        for (int i = 0; i < n; ++i) {
            if (customers[i] == 'N') {
                --penalty;
            } else {
                ++penalty;
            }
            if (penalty < minPenalty) {
                minPenalty = penalty;
                res = i + 1;
            }
        }
        return res;
    }
};