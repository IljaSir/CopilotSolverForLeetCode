class Solution {
public:
    int minOperationsMaxProfit(vector<int>& customers, int boardingCost, int runningCost) {
        
        int maxProfit = 0;
        int maxProfitRotation = -1;
        int totalProfit = 0;
        int totalCustomers = 0;
        int rotation = 0;
        for (int i = 0; i < customers.size(); i++) {
            totalCustomers += customers[i];
            int boarded = min(totalCustomers, 4);
            totalCustomers -= boarded;
            totalProfit += boarded * boardingCost - runningCost;
            rotation++;
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
                maxProfitRotation = rotation;
            }
        }
        while (totalCustomers > 0) {
            int boarded = min(totalCustomers, 4);
            totalCustomers -= boarded;
            totalProfit += boarded * boardingCost - runningCost;
            rotation++;
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
                maxProfitRotation = rotation;
            }
        }
        return maxProfitRotation;
    }
};