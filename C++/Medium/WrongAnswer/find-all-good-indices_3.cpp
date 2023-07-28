class Solution {
public:
    vector<int> goodIndices(vector<int>& nums, int k) {
        
        vector<int> ans;
        for (int i = k; i < nums.size() - k; ++i) {
            bool good = true;
            for (int j = i - 1; j > i - k - 1; --j) {
                if (nums[j] < nums[j + 1]) {
                    good = false;
                    break;
                }
            }
            if (!good) continue;
            for (int j = i + 1; j < i + k + 1; ++j) {
                if (nums[j] < nums[j - 1]) {
                    good = false;
                    break;
                }
            }
            if (good) ans.push_back(i);
        }
        return ans;
    }
};