class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int minutes) {
        
        int n = customers.size();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            if (grumpy[i] == 0) {
                sum += customers[i];
                customers[i] = 0;
            }
        }
        int maxSum = sum;
        for (int i = 0; i < n; ++i) {
            sum += customers[i];
            if (i - minutes >= 0) {
                sum -= customers[i - minutes];
            }
            maxSum = max(maxSum, sum);
        }
        return maxSum;
    }
};