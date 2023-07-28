class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int minutes) {
        
        int sum = 0;
        for (int i = 0; i < customers.size(); i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
                customers[i] = 0;
            }
        }
        int maxSum = sum;
        for (int i = 0; i < minutes; i++) {
            sum += customers[i];
        }
        maxSum = max(maxSum, sum);
        for (int i = minutes; i < customers.size(); i++) {
            sum -= customers[i - minutes];
            sum += customers[i];
            maxSum = max(maxSum, sum);
        }
        return maxSum;
    }
};