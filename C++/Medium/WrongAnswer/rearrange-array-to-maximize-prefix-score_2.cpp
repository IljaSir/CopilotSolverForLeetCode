class Solution {
public:
    int maxScore(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> prefix(n, 0);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }
        sort(nums.begin(), nums.end());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int score = 0;
            if (i == 0) {
                score = prefix[n-1];
            } else {
                score = prefix[n-1] - prefix[i-1];
            }
            if (nums[i] > 0) {
                score += nums[i];
            }
            ans = max(ans, score);
        }
        return ans;
    }
};