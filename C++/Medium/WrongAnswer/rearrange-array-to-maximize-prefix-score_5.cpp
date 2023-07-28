class Solution {
public:
    int maxScore(vector<int>& nums) {
        
        sort(nums.begin(),nums.end());
        vector<int> prefix(nums.size());
        prefix[0] = nums[0];
        for(int i=1;i<nums.size();i++)
            prefix[i] = prefix[i-1]+nums[i];
        int score = 0;
        for(int i=0;i<nums.size();i++) {
            if(prefix[i]>0)
                score++;
        }
        return score;
    }
};