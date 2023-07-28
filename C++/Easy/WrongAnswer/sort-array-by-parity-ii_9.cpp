class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& nums) {
        
        vector<int> result;
        int n = nums.size();
        int odd = 1;
        int even = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                result.push_back(nums[i]);
                result.push_back(0);
            } else {
                result.push_back(0);
                result.push_back(nums[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                while (result[even] % 2 != 0) {
                    even += 2;
                }
                result[i] = result[even];
                even += 2;
            } else {
                while (result[odd] % 2 == 0) {
                    odd += 2;
                }
                result[i] = result[odd];
                odd += 2;
            }
        }
        return result;
    }
};