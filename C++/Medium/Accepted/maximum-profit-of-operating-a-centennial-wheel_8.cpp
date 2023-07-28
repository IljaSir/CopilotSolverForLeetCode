class Solution {
public:
    int minOperationsMaxProfit(vector<int>& customers, int boardingCost, int runningCost) {
        
        int sum = 0, profit = 0, max_profit = 0, max_rotations = -1, wait = 0, rotations = 0;
        for (int i = 0; i < customers.size(); i++) {
            wait += customers[i];
            if (wait >= 4) {
                sum += 4 * boardingCost;
                wait -= 4;
            }
            else {
                sum += wait * boardingCost;
                wait = 0;
            }
            sum -= runningCost;
            rotations++;
            if (sum > max_profit) {
                max_profit = sum;
                max_rotations = rotations;
            }
        }
        while (wait > 0) {
            if (wait >= 4) {
                sum += 4 * boardingCost;
                wait -= 4;
            }
            else {
                sum += wait * boardingCost;
                wait = 0;
            }
            sum -= runningCost;
            rotations++;
            if (sum > max_profit) {
                max_profit = sum;
                max_rotations = rotations;
            }
        }
        return max_rotations;
    }
};