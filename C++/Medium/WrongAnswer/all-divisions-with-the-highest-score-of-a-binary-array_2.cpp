class Solution {
public:
    vector<int> maxScoreIndices(vector<int>& nums) {
        
        vector<int> left(nums.size(), 0);
        vector<int> right(nums.size(), 0);
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            left[i] = sum;
        }
        sum = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            sum += nums[i];
            right[i] = sum;
        }
        int maxScore = 0;
        vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            int score = left[i] + right[i];
            if (score > maxScore) {
                result.clear();
                result.push_back(i + 1);
                maxScore = score;
            } else if (score == maxScore) {
                result.push_back(i + 1);
            }
        }
        return result;
    }
};