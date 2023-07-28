class Solution {
public:
    int maxScore(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> prefix(n, 0);
        prefix[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        sort(nums.begin(), nums.end());
        int score = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                score += nums[i];
            }
        }
        for (int i = 1; i < n; ++i) {
            if (nums[i] > 0) {
                score += prefix[i - 1];
            }
        }
        return score;
    }
};