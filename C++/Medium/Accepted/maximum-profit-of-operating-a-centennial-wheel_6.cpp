class Solution {
public:
    int minOperationsMaxProfit(vector<int>& customers, int boardingCost, int runningCost) {
        
        int sum = 0;
        int maxProfit = 0;
        int maxRotations = 0;
        int rotations = 0;
        int n = customers.size();
        int i = 0;
        int waiting = 0;
        while (i < n || waiting > 0) {
            if (i < n) {
                waiting += customers[i];
            }
            int boarding = min(4, waiting);
            waiting -= boarding;
            sum += boarding * boardingCost - runningCost;
            rotations++;
            if (sum > maxProfit) {
                maxProfit = sum;
                maxRotations = rotations;
            }
            i++;
        }
        return maxProfit > 0 ? maxRotations : -1;
    }
};