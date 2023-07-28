class Solution {
public:
    int bestClosingTime(string customers) {
        
        int n = customers.size();
        int penalty = 0;
        int minPenalty = n;
        int minTime = n;
        for (int i = 0; i < n; i++) {
            if (customers[i] == 'Y') {
                penalty++;
            } else {
                penalty--;
            }
            if (penalty < minPenalty) {
                minPenalty = penalty;
                minTime = i;
            }
        }
        return minTime;
    }
};