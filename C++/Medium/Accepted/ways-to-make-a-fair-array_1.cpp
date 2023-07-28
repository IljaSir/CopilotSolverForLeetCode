class Solution {
public:
    int waysToMakeFair(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> odd(n + 1);
        vector<int> even(n + 1);
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                even[i + 1] = even[i] + nums[i];
                odd[i + 1] = odd[i];
            } else {
                odd[i + 1] = odd[i] + nums[i];
                even[i + 1] = even[i];
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (even[i] + odd[n] - odd[i + 1] == odd[i] + even[n] - even[i + 1]) {
                ++res;
            }
        }
        return res;
    }
};