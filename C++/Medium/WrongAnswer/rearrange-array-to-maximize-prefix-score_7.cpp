class Solution {
public:
    int maxScore(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 1) return 0;
        sort(nums.begin(), nums.end());
        int score = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                score += n - i;
            }
        }
        return score;
    }
};