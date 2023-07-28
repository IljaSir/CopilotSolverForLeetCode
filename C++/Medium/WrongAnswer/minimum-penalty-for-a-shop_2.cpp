class Solution {
public:
    int bestClosingTime(string customers) {
        
        int n = customers.size();
        int penalty = 0;
        for (int i = 0; i < n; i++) {
            if (customers[i] == 'Y') {
                penalty++;
            }
        }
        int bestPenalty = penalty;
        int bestHour = n;
        for (int i = n - 1; i >= 0; i--) {
            if (customers[i] == 'Y') {
                penalty--;
            } else {
                penalty++;
            }
            if (penalty < bestPenalty) {
                bestPenalty = penalty;
                bestHour = i;
            }
        }
        return bestHour;
    }
};