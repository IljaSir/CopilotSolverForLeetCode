class Solution {
public:
    int minNumberOperations(vector<int>& target) {
        
        int n = target.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sum += target[i];
            } else {
                if (target[i] > target[i - 1]) {
                    sum += target[i] - target[i - 1];
                }
            }
        }
        return sum;
    }
};