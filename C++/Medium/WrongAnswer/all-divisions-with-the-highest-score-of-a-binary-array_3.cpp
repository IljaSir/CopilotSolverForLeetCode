class Solution {
public:
    vector<int> maxScoreIndices(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                leftSum++;
            }
            left[i] = leftSum;
        }
        for (int i = n - 1; i >= 0; --i) {
            if (nums[i] == 1) {
                rightSum++;
            }
            right[i] = rightSum;
        }
        int maxScore = 0;
        vector<int> res;
        for (int i = 0; i < n; ++i) {
            int score = left[i] + right[i];
            if (score > maxScore) {
                maxScore = score;
                res.clear();
                res.push_back(i);
            } else if (score == maxScore) {
                res.push_back(i);
            }
        }
        return res;
    }
};