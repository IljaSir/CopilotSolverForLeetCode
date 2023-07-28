class Solution {
public:
    int maxSatisfaction(vector<int>& satisfaction) {
        
        sort(satisfaction.begin(), satisfaction.end());
        int n = satisfaction.size();
        int ans = 0, sum = 0;
        for (int i = n - 1; i >= 0; --i) {
            sum += satisfaction[i];
            if (sum > 0) ans += sum;
            else break;
        }
        return ans;
    }
};