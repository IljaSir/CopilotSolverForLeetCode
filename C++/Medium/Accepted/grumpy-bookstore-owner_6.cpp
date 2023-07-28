class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int minutes) {
        
        int n = customers.size();
        int maxSatisfied = 0;
        for (int i = 0; i < n; ++i) {
            if (!grumpy[i]) {
                maxSatisfied += customers[i];
            }
        }
        int maxIncrease = 0;
        for (int i = 0; i < minutes; ++i) {
            if (grumpy[i]) {
                maxIncrease += customers[i];
            }
        }
        int increase = maxIncrease;
        for (int i = 1; i <= n - minutes; ++i) {
            if (grumpy[i - 1]) {
                increase -= customers[i - 1];
            }
            if (grumpy[i + minutes - 1]) {
                increase += customers[i + minutes - 1];
            }
            maxIncrease = max(maxIncrease, increase);
        }
        return maxSatisfied + maxIncrease;
    }
};