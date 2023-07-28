class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        
        int n = gas.size();
        int i = 0;
        while (i < n) {
            int count = 0;
            int sumOfGas = 0;
            int sumOfCost = 0;
            while (count < n) {
                int j = (i + count) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                count++;
            }
            if (count == n) {
                return i;
            } else {
                i = i + count + 1;
            }
        }
        return -1;
    }
};