class Solution {
public:
    string getPermutation(int n, int k) {
        
        vector<int> nums(n, 0);
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        while (--k) {
            nextPermutation(nums);
        }
        string res;
        for (int i = 0; i < n; i++) {
            res += to_string(nums[i]);
        }
        return res;
    }
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums[i], nums[j]);
        }
        reverse(nums.begin() + i + 1, nums.end());
    }
};