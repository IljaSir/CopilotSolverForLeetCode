class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int minutes) {
        
        int n = customers.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
                customers[i] = 0;
            }
        }
        int maxSum = 0;
        int curSum = 0;
        for (int i = 0; i < minutes; i++) {
            curSum += customers[i];
        }
        maxSum = curSum;
        for (int i = minutes; i < n; i++) {
            curSum += customers[i] - customers[i - minutes];
            maxSum = max(maxSum, curSum);
        }
        return sum + maxSum;
    }
};