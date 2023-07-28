class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& values) {
        
        int n = values.size();
        int ans = 0;
        int max_value = values[0] + 0;
        for (int j = 1; j < n; j++) {
            ans = max(ans, max_value + values[j] - j);
            max_value = max(max_value, values[j] + j);
        }
        return ans;
    }
};