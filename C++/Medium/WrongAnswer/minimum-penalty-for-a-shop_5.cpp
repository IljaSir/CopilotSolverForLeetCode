class Solution {
public:
    int bestClosingTime(string customers) {
        
        int n = customers.size();
        int penalty = 0;
        int min_penalty = 0;
        for (int i = 0; i < n; i++) {
            if (customers[i] == 'N') {
                penalty++;
            }
        }
        min_penalty = penalty;
        int best_hour = 0;
        for (int i = 0; i < n; i++) {
            if (customers[i] == 'N') {
                penalty--;
            }
            if (customers[i] == 'Y') {
                penalty++;
            }
            if (penalty < min_penalty) {
                min_penalty = penalty;
                best_hour = i + 1;
            }
        }
        return best_hour;
    }
};