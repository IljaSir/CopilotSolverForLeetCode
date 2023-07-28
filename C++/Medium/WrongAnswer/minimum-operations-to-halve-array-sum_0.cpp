class Solution {
public:
    int halveArray(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }
        sort(nums.begin(), nums.end());
        int res = 0;
        for (int i = n - 1; i >= 0; --i) {
            sum -= nums[i];
            ++res;
            if (sum * 2 <= nums[i]) {
                break;
            }
        }
        return res;
    }
    int minOperations(vector<int>& nums) {
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return halveArray(nums);
        }
        int target = sum / 2;
        int res = 0;
        for (int i = n - 1; i >= 0; --i) {
            sum -= nums[i];
            ++res;
            if (sum <= target) {
                break;
            }
        }
        return res;
    }
};