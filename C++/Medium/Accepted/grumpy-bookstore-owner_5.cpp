class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int minutes) {
        
        int n = customers.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (!grumpy[i]) {
                sum += customers[i];
                customers[i] = 0;
            }
        }
        int maxIncrease = 0;
        int increase = 0;
        for (int i = 0; i < n; i++) {
            increase += customers[i];
            if (i >= minutes) {
                increase -= customers[i - minutes];
            }
            maxIncrease = max(maxIncrease, increase);
        }
        return sum + maxIncrease;
    }
};