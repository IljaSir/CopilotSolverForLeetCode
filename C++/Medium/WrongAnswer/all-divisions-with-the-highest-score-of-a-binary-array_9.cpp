class Solution {
public:
    vector<int> maxScoreIndices(vector<int>& nums) {
        
        vector<int> ans;
        int n = nums.size();
        int sum = 0;
        for(int i=0; i<n; i++) sum += nums[i];
        int max_score = INT_MIN;
        int score = 0;
        for(int i=0; i<n; i++) {
            score = sum + i;
            if(score > max_score) {
                max_score = score;
                ans.clear();
                ans.push_back(i);
            } else if(score == max_score) {
                ans.push_back(i);
            }
            if(nums[i] == 1) sum--;
        }
        return ans;
    }
};