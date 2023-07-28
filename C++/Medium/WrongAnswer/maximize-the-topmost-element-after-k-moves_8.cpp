class Solution {
public:
    int maximumTop(vector<int>& nums, int k) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < k; ++i) {
            int j = 0;
            while (j < n && nums[j] == 0) ++j;
            if (j == n) return -1;
            nums[j] = 0;
            while (j > 0 && nums[j-1] == 0) --j;
            ++nums[j];
        }
        for (int i = 0; i < n; ++i) {
            res = max(res, nums[i]);
        }
        return res;
    }
};