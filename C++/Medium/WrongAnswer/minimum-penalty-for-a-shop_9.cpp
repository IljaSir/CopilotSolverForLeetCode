class Solution {
public:
    int bestClosingTime(string customers) {
        
        int n = customers.size();
        int penalty = 0, min_penalty = n;
        int bestHour = 0;
        for (int i = 0; i < n; i++) {
            if (customers[i] == 'N') {
                penalty++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (customers[i] == 'Y') {
                penalty++;
            }
            if (customers[(i + 1) % n] == 'N') {
                penalty--;
            }
            if (penalty < min_penalty) {
                min_penalty = penalty;
                bestHour = i + 1;
            }
        }
        return bestHour;
    }
};