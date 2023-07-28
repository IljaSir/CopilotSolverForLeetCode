class Solution {
public:
    int bestClosingTime(string customers) {
        
        int n = customers.size();
        int penalty = 0;
        for (int i = 0; i < n; ++i) {
            if (customers[i] == 'N') {
                penalty++;
            }
        }
        int best = penalty;
        int bestHour = 0;
        for (int i = 0; i < n; ++i) {
            if (customers[i] == 'N') {
                penalty++;
            } else {
                penalty--;
            }
            if (penalty < best) {
                best = penalty;
                bestHour = i + 1;
            }
        }
        return bestHour;
    }
};