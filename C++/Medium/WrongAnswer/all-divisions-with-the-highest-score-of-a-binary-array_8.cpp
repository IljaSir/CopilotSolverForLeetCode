class Solution {
public:
    vector<int> maxScoreIndices(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> res;
        int max = 0;
        int ones = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                ++ones;
            }
            int score = i + 1 - ones;
            if (score > max) {
                res.clear();
                max = score;
                res.push_back(i);
            }
            else if (score == max) {
                res.push_back(i);
            }
        }
        return res;
    }
};