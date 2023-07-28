class Solution {
public:
    long long findScore(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        long long score = 0;
        while (i < n) {
            int j = i;
            while (j < n && nums[j] == nums[i]) j++;
            score += nums[i];
            i = j + 1;
        }
        return score;
    }
};