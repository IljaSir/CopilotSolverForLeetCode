class Solution {
public:
    int maxSatisfaction(vector<int>& satisfaction) {
        
        sort(satisfaction.begin(), satisfaction.end());
        int n = satisfaction.size();
        int sum = 0;
        int res = 0;
        for (int i = n - 1; i >= 0; --i) {
            sum += satisfaction[i];
            if (sum > 0) {
                res += sum;
            } else {
                break;
            }
        }
        return res;
    }
};