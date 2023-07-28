class Solution {
public:
    vector<int> maxScoreIndices(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> prefix(n+1, 0);
        for (int i = 0; i < n; ++i) {
            prefix[i+1] = prefix[i] + nums[i];
        }
        int max_score = 0;
        vector<int> res;
        for (int i = 0; i <= n; ++i) {
            int score = prefix[i] + (n-i) - (prefix[n] - prefix[i]);
            if (score > max_score) {
                max_score = score;
                res = {i};
            } else if (score == max_score) {
                res.push_back(i);
            }
        }
        return res;
    }
};