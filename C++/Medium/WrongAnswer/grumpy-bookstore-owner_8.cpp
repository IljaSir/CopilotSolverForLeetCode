class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int minutes) {
        
        int n = customers.size();
        int gain = 0;
        int max_gain = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                gain += customers[i];
            }
            if (i < minutes) {
                max_gain += customers[i] * grumpy[i];
            } else {
                max_gain += customers[i] * grumpy[i] - customers[i - minutes] * grumpy[i - minutes];
            }
        }
        return gain + max_gain;
    }
};