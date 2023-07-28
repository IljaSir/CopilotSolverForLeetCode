class Solution {
public:
    int minOperationsMaxProfit(vector<int>& customers, int boardingCost, int runningCost) {
        
        int n = customers.size();
        int maxProfit = 0;
        int maxProfitIndex = -1;
        int currentProfit = 0;
        int currentCustomers = 0;
        int currentRotation = 0;
        for (int i = 0; i < n; ++i) {
            currentCustomers += customers[i];
            ++currentRotation;
            int boardingCustomers = min(4, currentCustomers);
            currentCustomers -= boardingCustomers;
            currentProfit += boardingCustomers * boardingCost - runningCost;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                maxProfitIndex = currentRotation;
            }
        }
        while (currentCustomers > 0) {
            ++currentRotation;
            int boardingCustomers = min(4, currentCustomers);
            currentCustomers -= boardingCustomers;
            currentProfit += boardingCustomers * boardingCost - runningCost;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                maxProfitIndex = currentRotation;
            }
        }
        return maxProfit > 0 ? maxProfitIndex : -1;
    }
};