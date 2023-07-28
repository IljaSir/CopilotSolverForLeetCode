class Solution {
public:
    vector<int> goodIndices(vector<int>& nums, int k) {
        
        vector<int> res;
        int n = nums.size();
        for (int i = k; i < n - k; ++i) {
            int j = i - 1;
            while (j >= i - k && nums[j] >= nums[j + 1]) --j;
            if (j == i - k - 1) {
                j = i + 1;
                while (j <= i + k && nums[j] >= nums[j - 1]) ++j;
                if (j == i + k + 1) res.push_back(i);
            }
        }
        return res;
    }
};