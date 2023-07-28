class Solution {
public:
    int maxScore(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int prefix = 0;
        int score = 0;
        for(int i = 0; i < n; i++) {
            prefix += nums[i];
            if(prefix > 0) {
                score++;
            }
        }
        return score;
    }
};