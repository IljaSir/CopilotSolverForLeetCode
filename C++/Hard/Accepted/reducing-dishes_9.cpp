class Solution {
public:
    int maxSatisfaction(vector<int>& satisfaction) {
        
        sort(satisfaction.begin(), satisfaction.end());
        int maxSum = 0;
        int n = satisfaction.size();
        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            int t = 1;
            for (int j = i; j < n; j++) {
                sum += t * satisfaction[j];
                t++;
            }
            if (maxSum < sum) {
                maxSum = sum;
            } else {
                break;
            }
        }
        return maxSum;
    }
};