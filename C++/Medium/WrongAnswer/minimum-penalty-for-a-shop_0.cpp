class Solution {
public:
    int bestClosingTime(string customers) {
        
        int n = customers.size();
        int penalty = 0;
        for (int i = 0; i < n; i++) {
            if (customers[i] == 'N') {
                penalty++;
            }
        }
        int minPenalty = penalty;
        int minPenaltyHour = 0;
        for (int i = 0; i < n; i++) {
            if (customers[i] == 'Y') {
                penalty++;
            } else {
                penalty--;
            }
            if (penalty < minPenalty) {
                minPenalty = penalty;
                minPenaltyHour = i + 1;
            }
        }
        return minPenaltyHour;
    }
};