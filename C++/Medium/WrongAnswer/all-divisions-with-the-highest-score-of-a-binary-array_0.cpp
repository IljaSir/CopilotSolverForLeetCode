class Solution {
public:
    vector<int> maxScoreIndices(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> prefix(n + 1);
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int maxScore = 0;
        vector<int> ans;
        for (int i = 0; i <= n; ++i) {
            int score = prefix[i] + (n - i) - (prefix[n] - prefix[i]);
            if (score > maxScore) {
                maxScore = score;
                ans = {i};
            } else if (score == maxScore) {
                ans.push_back(i);
            }
        }
        return ans;
    }
};