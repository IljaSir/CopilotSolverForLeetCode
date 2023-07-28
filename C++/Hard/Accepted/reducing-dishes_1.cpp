class Solution {
public:
    int maxSatisfaction(vector<int>& satisfaction) {
        
        sort(satisfaction.begin(), satisfaction.end());
        int ans = 0, sum = 0;
        for (int i = satisfaction.size() - 1; i >= 0 && satisfaction[i] > -sum; i--) {
            sum += satisfaction[i];
            ans += sum;
        }
        return ans;
    }
};