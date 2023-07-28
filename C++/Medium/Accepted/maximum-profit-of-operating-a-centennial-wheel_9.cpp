class Solution {
public:
    int minOperationsMaxProfit(vector<int>& customers, int boardingCost, int runningCost) {
        
        int n= customers.size();
        int maxProfit=0;
        int maxProfitIndex=0;
        int currentProfit=0;
        int currentCustomers=0;
        int currentRotations=0;
        int currentBoarding=0;
        for(int i=0;i<n;i++){
            currentRotations++;
            currentCustomers+=customers[i];
            currentBoarding=min(currentCustomers,4);
            currentCustomers-=currentBoarding;
            currentProfit+=currentBoarding*boardingCost-runningCost;
            if(currentProfit>maxProfit){
                maxProfit=currentProfit;
                maxProfitIndex=currentRotations;
            }
        }
        while(currentCustomers>0){
            currentRotations++;
            currentBoarding=min(currentCustomers,4);
            currentCustomers-=currentBoarding;
            currentProfit+=currentBoarding*boardingCost-runningCost;
            if(currentProfit>maxProfit){
                maxProfit=currentProfit;
                maxProfitIndex=currentRotations;
            }
        }
        if(maxProfit<=0)
            return -1;
        else
            return maxProfitIndex;
    }
};