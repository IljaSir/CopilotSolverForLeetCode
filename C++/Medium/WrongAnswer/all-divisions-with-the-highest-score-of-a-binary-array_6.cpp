class Solution {
public:
    vector<int> maxScoreIndices(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> result;
        int maxScore = 0;
        int leftZeros = 0;
        int rightOnes = accumulate(nums.begin(), nums.end(), 0);
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) leftZeros++;
            else rightOnes--;
            int score = leftZeros + rightOnes;
            if (score > maxScore) {
                maxScore = score;
                result = { i + 1 };
            } else if (score == maxScore) {
                result.push_back(i + 1);
            }
        }
        return result;
    }
};