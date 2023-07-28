class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> prefix(n+1, 0);
        for (int i = 0; i < n; ++i) {
            prefix[i+1] = prefix[i] + nums[i];
        }
        int minIndex = 0;
        double minDiff = 1e9;
        for (int i = 0; i < n; ++i) {
            double diff = (prefix[i+1] - prefix[0]) * 1.0 / (i+1) - (prefix[n] - prefix[i+1]) * 1.0 / (n - i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                minIndex = i;
            }
        }
        return minIndex;
    }
};