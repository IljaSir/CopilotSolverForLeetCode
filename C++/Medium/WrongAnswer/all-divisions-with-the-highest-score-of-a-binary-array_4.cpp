class Solution {
public:
    vector<int> maxScoreIndices(vector<int>& nums) {
        
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int maxScore = 0;
        vector<int> res;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                sum++;
            } else {
                sum--;
            }
            if (sum > maxScore) {
                maxScore = sum;
                res = {i + 1};
            } else if (sum == maxScore) {
                res.push_back(i + 1);
            }
        }
        return res;
    }
};