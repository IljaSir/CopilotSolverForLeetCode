class Solution {
public:
    int halveArray(vector<int>& nums) {
        
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        sort(nums.begin(), nums.end());
        int res = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            sum -= nums[i];
            res++;
            if (sum <= 0) {
                return res;
            }
        }
        return res;
    }
    int minOperations(vector<int>& nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        int res = 0;
        while (sum > 0) {
            sum /= 2;
            res++;
        }
        return res - halveArray(nums);
    }
};