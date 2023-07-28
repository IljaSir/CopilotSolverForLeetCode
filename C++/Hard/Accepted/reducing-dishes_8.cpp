class Solution {
public:
    int maxSatisfaction(vector<int>& satisfaction) {
        
        sort(satisfaction.begin(), satisfaction.end());
        int n = satisfaction.size();
        int sum = 0, cur = 0;
        for (int i = n - 1; i >= 0; --i) {
            cur += satisfaction[i];
            if (cur > 0) {
                sum += cur;
            } else {
                break;
            }
        }
        return sum;
    }
};