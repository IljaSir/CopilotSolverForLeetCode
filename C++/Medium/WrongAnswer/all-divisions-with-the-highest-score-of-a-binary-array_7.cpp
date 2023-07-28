class Solution {
public:
    vector<int> maxScoreIndices(vector<int>& nums) {
        
        vector<int> result;
        int n = nums.size();
        vector<int> zeros(n, 0);
        vector<int> ones(n, 0);
        for(int i = 0; i < n; i++) {
            zeros[i] = nums[i] == 0 ? 1 : 0;
            ones[i] = nums[i] == 1 ? 1 : 0;
        }
        for(int i = 1; i < n; i++) {
            zeros[i] += zeros[i - 1];
            ones[i] += ones[i - 1];
        }
        int maxScore = 0;
        for(int i = 0; i < n; i++) {
            int score = zeros[i] + ones[n - 1] - ones[i];
            if(score > maxScore) {
                maxScore = score;
                result.clear();
                result.push_back(i + 1);
            } else if(score == maxScore) {
                result.push_back(i + 1);
            }
        }
        return result;
    }
};