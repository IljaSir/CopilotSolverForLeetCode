class Solution {
public:
    vector<int> maxScoreIndices(vector<int>& nums) {
        
        int n = nums.size();
        int count1 = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                count1++;
            }
        }
        int count0 = 0;
        int maxScore = 0;
        vector<int> result;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                count0++;
            } else {
                count1--;
            }
            int score = count0 + count1;
            if(score > maxScore) {
                maxScore = score;
                result.clear();
                result.push_back(i);
            } else if(score == maxScore) {
                result.push_back(i);
            }
        }
        return result;
    }
};